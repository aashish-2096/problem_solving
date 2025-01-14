class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        unordered_map<int, int> mp;
        for (int i = 0; i < A.size(); i++) {
            mp[A[i]] = i;
        }
        vector<int> res(A.size(), 0);
        for (int i = 0; i < B.size(); i++) {
            int count = 0;
            for (int j = 0; j <= i; j++) {
                if (mp[B[j]] <= i) {
                    count += 1;
                }
            }
            res[i] = count;
        }
        return res;
    }
};