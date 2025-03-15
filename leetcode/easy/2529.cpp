class Solution {
    public:
        int maximumCount(vector<int>& nums) {
            int maxVal = INT_MIN;
            int size = nums.size();
            int count = 0, zero = 0;
            for (auto i : nums) {
                if (i > 0 && i != 0) {
                    count += 1;
                } else if (i == 0) {
                    zero++;
                }
            }
            maxVal = max(maxVal, count);
            maxVal = max(maxVal, size - count - zero);
            return maxVal;
        }
    };