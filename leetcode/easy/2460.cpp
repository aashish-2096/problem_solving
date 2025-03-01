class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i - 1] = nums[i] * 2;
                nums[i] = 0;
            }
        }
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                res.push_back(nums[i]);
            }
        }
        for (int i = res.size(); i < nums.size(); i++) {
            res.push_back(0);
        }
        return res;
    }
};