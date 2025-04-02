
class Solution {
    public:
        void recursion(vector<int>& nums, int index, vector<int>& arr,
                       vector<vector<int>>& res) {
            res.push_back(arr);
            for (int i = index; i < nums.size(); i++) {
                if (i > index && nums[i] == nums[i - 1])
                    continue;
                arr.push_back(nums[i]);
                recursion(nums, i + 1, arr, res);
                arr.pop_back();
            }
        }
        vector<vector<int>> subsetsWithDup(vector<int>& nums) {
            vector<vector<int>> res;
            vector<int> vt;
            sort(nums.begin(), nums.end());
            recursion(nums, 0, vt, res);
            return res;
        }
    };