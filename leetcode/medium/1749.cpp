class Solution {
    public:
        int maxAbsoluteSum(vector<int>& nums) {
            int maxSum = INT_MIN, currenSumPositive = 0, currenSumNeg = 0;
            for (int i = 0; i < nums.size(); i++) {
                currenSumPositive += nums[i];
                currenSumNeg += nums[i];
                int absSum = abs(currenSumNeg);
                maxSum = max(maxSum, currenSumPositive);
                maxSum = max(maxSum, absSum);
                if (currenSumPositive < 0) {
                    currenSumPositive = 0;
                }
                if (currenSumNeg > 0) {
                    currenSumNeg = 0;
                }
            }
            return maxSum;
        }
    };