/**
O(N^2), could be optmized using two pass approach.
*/

class Solution {
public:
    vector<int> minOperations(string boxes) {
        int len = boxes.length();
        vector<int> res(len);
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                if (i != j)
                    sum += abs(i - j) * (boxes[j] - '0');
            }
            res[i] = sum;
        }
        return res;
    }
};