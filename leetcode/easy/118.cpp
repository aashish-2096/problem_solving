class Solution {
    public:
        vector<vector<int>> generate(int numRows) {
            vector<vector<int>> vt;
            vector<int> prev = {1};
            vt.push_back(prev);
            for (int i = 1; i < numRows; i++) {
                int size = prev.size() + 1;
                vector<int> temp(size, 1);
                if (prev.size() >= 2) {
                    for (int i = 1; i < prev.size(); i++) {
                        temp[i] = prev[i - 1] + prev[i];
                    }
                }
                vt.push_back(temp);
                prev = temp;
            }
            return vt;
        }
    };