class Solution {
    public:
        int rowSize, colSize;
        void updateZeroes(vector<vector<int>>& matrix, int row, int col) {
            for (int i = 0; i < colSize; i++) {
                matrix[row][i] = 0;
            }
            for (int i = 0; i < rowSize; i++) {
                matrix[i][col] = 0;
            }
        }
        void setZeroes(vector<vector<int>>& matrix) {
            colSize = matrix[0].size();
            rowSize = matrix.size();
            multimap<int, int> mp;
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (matrix[i][j] == 0) {
                        mp.insert({i, j});
                    }
                }
            }
            for (auto m : mp) {
                updateZeroes(matrix, m.first, m.second);
            }
        }
    };