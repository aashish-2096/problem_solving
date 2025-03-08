class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        vector<int> res, res2;
        int count = 0;
        for (auto i : nums) {
            if (i < pivot) {
                res.push_back(i);
            } else if (i > pivot) {
                res2.push_back(i);
            } else {
                count += 1;
            }
        }
        res.insert(res.end(), count, pivot);
        res.insert(res.end(), res2.begin(), res2.end());
        return res;
    }
};