class Solution {
    public:
        void recursion(vector<int>& nums, int index, int target, vector<int> res,
                       vector<vector<int>>& result) {
            if (target == 0) {
                result.push_back(res);
                return;
            }
            if (target < 0 || index == nums.size())
                return;
            recursion(nums, index + 1, target, res, result);
            res.push_back(nums[index]);
            recursion(nums, index, target - nums[index], res, result);
        }
        vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
            vector<vector<int>> result;
            sort(candidates.begin(), candidates.end());
            vector<int> vt;
            recursion(candidates, 0, target, vt, result);
            return result;
        }
    };