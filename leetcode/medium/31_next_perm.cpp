class Solution {
    public:
        void nextPermutation(vector<int>& nums) {
            // next_permutation(nums.begin(), nums.end());
            int index = -1;
            int size = nums.size();
            for (int i = size - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                reverse(nums.begin(), nums.end());
            } else {
                for (int i = size - 1; i >= index + 1; i--) {
                    if (nums[i] > nums[index]) {
                        swap(nums[i], nums[index]);
                        break;
                    }
                }
                reverse(nums.begin() + index + 1, nums.end());
            }
        }
    };