class Solution {
    public:
        void sortColors(vector<int>& nums) {
            int one = 0, two = 0, zero = 0;
            for (auto i : nums) {
                if (i == 1) {
                    one += 1;
                } else if (i == 2) {
                    two += 1;
                }
            }
            for (int i = nums.size() - 1; i >= 0; i--) {
                if (two > 0) {
                    nums[i] = 2;
                    two--;
                } else if (one > 0) {
                    nums[i] = 1;
                    one--;
                } else {
                    nums[i] = 0;
                }
            }
        }
    };