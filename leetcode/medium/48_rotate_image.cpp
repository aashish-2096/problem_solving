class Solution {
    public:
        void rotate(vector<vector<int>>& nums) {
            int n = nums.size();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < j)
                        swap(nums[i][j], nums[j][i]);
                }
            }
    
            for (int i = 0; i < n; i++) {
                int left = 0, right = n - 1;
                while (left < right) {
                    swap(nums[i][left], nums[i][right]);
                    left++;
                    right--;
                }
            }
        }
    };