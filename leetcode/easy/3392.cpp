class Solution {
    public:
        int countSubarrays(vector<int>& nums) {
            int count = 0;
            for(int i = 1; i<nums.size()-1;i++){
                int prev = nums[i-1];
                int curr = nums[i];
                int next = nums[i+1];
                if(curr == (prev+next)*2){
                    count+=1;
                }
            }
            return count;
        }
    };