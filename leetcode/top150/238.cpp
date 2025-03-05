class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> prefix, postfix(nums.size(), 0);
        int num = 1;
        for (auto i : nums) {
            num *= i;
            prefix.push_back(num);
        }
        num = 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            num *= nums[i];
            postfix[i] = num;
        }
        vector<int> res(nums.size(), 0);
        res[0] = postfix[1];
        res[nums.size() - 1] = prefix[nums.size() - 2];
        for (int i = 1; i < nums.size() - 1; i++) {
            int mult = prefix[i - 1] * postfix[i + 1];
            res[i] = mult;
        }
        return res;
    }
};