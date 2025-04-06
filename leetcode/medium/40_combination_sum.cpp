class Solution {
    public:
        void recursion(vector<int>& nums, int index, int target, vector<int> res,
                       vector<vector<int>>& result) {
            if (target == 0) {
                result.push_back(res);
                return;
            }
    
            for (int i = index; i < nums.size(); i++) {
                if (i > index && nums[i] == nums[i - 1]) continue;
                if (nums[i] > target) break;
                res.push_back(nums[i]);
                recursion(nums, i+1, target - nums[i], res, result);
                res.pop_back();
            }
        }
        vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
            vector<vector<int>> result;
            sort(candidates.begin(), candidates.end());
            vector<int> vt;
            recursion(candidates, 0, target, vt, result);
            return result;
        }
    };