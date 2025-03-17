class Solution {
    public:
        bool divideArray(vector<int>& nums) {
            if (nums.size() % 2 != 0)
                return false;
            sort(nums.begin(), nums.end());
            int num = nums[0];
            for (int i = 1; i < nums.size(); i++) {
                num += (nums[i] * (i%2 == 0 ? 1: -1));
            } 
            return num == 0;
        }
    };