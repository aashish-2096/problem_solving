class Solution {
public:
    vector<vector<int>> mergeArrays(vector<vector<int>>& nums1,
                                    vector<vector<int>>& nums2) {
        map<int, int> mp;
        int left = 0, right = 0;
        int lSize = nums1.size(), rSize = nums2.size();
        while (left < lSize && right < rSize) {
            int lIndex = nums1[left][0];
            int rIndex = nums2[right][0];
            int lVal = nums1[left][1];
            int rVal = nums2[right][1];
            if (lIndex == rIndex) {
                left++;
                right++;
                int sum = lVal + rVal;
                mp.insert({lIndex, sum});
            } else if (lIndex < rIndex) {
                left++;
                mp.insert({lIndex, lVal});
            } else if (rIndex < lIndex) {
                right++;
                mp.insert({rIndex, rVal});
            }
        }

        if (left < lSize) {
            for (int i = left; i < lSize; i++) {
                mp.insert({nums1[i][0], nums1[i][1]});
            }
        }
        if (right < rSize) {a
            for (int i = right; i < rSize; i++) {
                mp.insert({nums2[i][0], nums2[i][1]});
            }
        }

        vector<vector<int>> res;
        for (auto m : mp) {
            vector<int> vt;
            vt.push_back(m.first);
            vt.push_back(m.second);
            res.push_back(vt);
        }
        return res;
    }
};