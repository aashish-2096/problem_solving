class Solution {
    public:
        long long maximumTripletValue(vector<int>& nums) {
            long long maxVal = 0;
            vector<int> maxStart, maxEnd;
            int maxEndVal = -1;
            for (int i = nums.size() - 1; i >= 0; i--) {
                if (maxEnd.empty()) {
                    maxEnd.push_back(nums[i]);
                    maxEndVal = nums[i];
                } else {
                    if (maxEndVal < nums[i]) {
                        maxEnd.push_back(nums[i]);
                        maxEndVal = nums[i];
                    } else {
                        maxEnd.push_back(maxEndVal);
                    }
                }
            }
            reverse(maxEnd.begin(), maxEnd.end());
            int maxStartVal = -1;
            for (int i = 0; i < nums.size(); i++) {
                if (maxStart.empty()) {
                    maxStart.push_back(nums[i]);
                    maxStartVal = nums[i];
                } else {
                    if (nums[i] > maxStartVal) {
                        maxStart.push_back(nums[i]);
                        maxStartVal = nums[i];
                    } else {
                        maxStart.push_back(maxStartVal);
                    }
                }
            }
            for (int i = 1; i < nums.size() - 1; i++) {
                long long val =
                    (maxStart[i - 1] - nums[i]) * (long long)maxEnd[i + 1];
                maxVal = max(maxVal, val);
            }
            return maxVal;
        }
    };