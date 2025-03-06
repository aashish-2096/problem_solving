class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        int n = grid[0].size();
        int a = -1, b = -1;
        vector<int> res((n * n) + 1, 0);
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                int val = grid[i][j];
                if (res[val] == 1) {
                    a = val;
                }
                res[val] += 1;
            }
        }

        for (int i = 1; i <= res.size(); i++) {
            if (res[i] == 0) {
                b = i;
                break;
            }
        }
        vector<int> temp({a, b});
        return temp;
    }
};