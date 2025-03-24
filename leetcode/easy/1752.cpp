class Solution {
    public:
        bool check(vector<int>& nums) {
            int ii = 0;
            for (int i = 1; i < nums.size(); i++) {
                if (nums[i] < nums[i - 1]) {
                    ii = i;
                    break;
                }
            }
            if (ii == 0) {
                return true;
            } else if (ii <= nums.size() - 1) {
                bool isSorted = is_sorted(nums.begin(), nums.begin() + ii) &&
                                is_sorted(nums.begin() + ii, nums.end());
                bool status = true;
                if (nums[0] < nums[nums.size() - 1]) {
                    status = false;
                }
                return isSorted && status;
            }
            return false;
        }
    };

// Checking the drop if more than once, if yes not sorted or rotated. Memory efficient O(n)
    class Solution {
        public:
            bool check(vector<int>& nums) {
                int dropCount = 0;
                int n = nums.size();
                for (int i = 0; i < n; i++) {
                    if (nums[i] > nums[(i + 1) % n]) {
                        dropCount += 1;
                    }
                    if (dropCount > 1) {
                        return false;
                    }
                }
                return true;
            }
        };