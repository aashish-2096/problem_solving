class Solution {
    public:
        long long maximumTripletValue(vector<int>& nums) {
            long long maxVal = 0;
            for (int i = nums.size() - 1; i >= 2; i--) {
                for (int j = i - 1; j >= 1; j--) {
                    for (int k = j - 1; k >= 0; k--) {
                        long long val = (long long)nums[i] * (nums[k] - nums[j]);
                        if (val < 0) {
                            val = 0;
                        }
                        maxVal = max(val, maxVal);
                    }
                }
            }
            return maxVal;
        }
    };