class Solution {
    public:
        void recursion(vector<int>& nums, vector<bool> taken, vector<int> res,
                       vector<vector<int>>& result) {
            if (nums.size() == res.size()) {
                result.push_back(res);
                return;
            }
            for (int i = 0; i < taken.size(); i++) {
                if (!taken[i]) {
                    taken[i] = true;
                    res.push_back(nums[i]);
                    recursion(nums, taken, res, result);
                    taken[i] = false;
                    res.pop_back();
                }
            }
        }
        vector<vector<int>> permute(vector<int>& nums) {
            vector<bool> taken(nums.size(), false);
            vector<vector<int>> result;
            vector<int> res;
            recursion(nums, taken, res, result);
            return result;
        }
    };