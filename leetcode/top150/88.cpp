class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int> res;
        int i1 = 0, i2 = 0;
        while (i1 < m && i2 < n) {
            if (nums1[i1] <= nums2[i2]) {
                res.push_back(nums1[i1]);
                i1++;
            } else {
                res.push_back(nums2[i2]);
                i2++;
            }
        }
        if (i1 < m) {
            while (i1 < m) {
                res.push_back(nums1[i1]);
                i1++;
            }
        }
        if (i2 < n) {
            while (i2 < n) {
                res.push_back(nums2[i2]);
                i2++;
            }
        }
        nums1 = res;
    }
};