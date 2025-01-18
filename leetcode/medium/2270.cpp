/**
- PrefixSum to get the sum at the index
- Difference of total - indexSum to get the split diff
*/

class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        int size = nums.size();
        vector<long>prefixSum(size,0);
        long sum = 0;
        for(int i = 0;i<size;i++){
            sum+=nums[i];
            prefixSum[i] = sum;
        }

        int noOfSplits = 0;
        for(int i = 1;i<=size-1;i++){
            long lSum = prefixSum[i-1];
            long rSum = sum-lSum;
            if(lSum >= rSum){
                noOfSplits+=1;
            }
        }
        return noOfSplits;
    }
};