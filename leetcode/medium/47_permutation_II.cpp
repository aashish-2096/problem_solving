class Solution {
    public:
        set<vector<int>> result;
        void recursion(vector<int>& nums, vector<bool> taken, vector<int> res) {
            if (nums.size() == res.size()) {
                result.insert(res);
                return;
            }
            for (int i = 0; i < taken.size(); i++) {
                if (!taken[i]) {
                    taken[i] = true;
                    res.push_back(nums[i]);
                    recursion(nums, taken, res);
                    taken[i] = false;
                    res.pop_back();
                }
            }
        }
        vector<vector<int>> permuteUnique(vector<int>& nums) {
            vector<bool> taken(nums.size(), false);
            vector<int> res;
            recursion(nums, taken, res);
            vector<vector<int>> vc(result.begin(), result.end());
            return vc;
        }
    };