class Solution {
    public:
        int indexForRow(vector<int> vt, int target) {
            int low = 0, high = vt.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (vt[mid] == target) {
                    return mid;
                } else if (vt[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return high;
        }
    
        bool indexForCol(vector<int> vt, int target) {
            int low = 0, high = vt.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (vt[mid] == target) {
                    return true;
                } else if (vt[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
        bool searchMatrix(vector<vector<int>>& matrix, int target) {
            vector<int> col;
            for (int i = 0; i < matrix.size(); i++) {
                col.push_back(matrix[i][0]);
            }
            int row = indexForRow(col, target);
            if (row < matrix.size()) {
                return indexForCol(matrix[row], target);
            }
            return false;
        }
    };