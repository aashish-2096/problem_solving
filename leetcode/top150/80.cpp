// Can be simplified further with O(n), taking when i == 2 and only considering when i-2 != i

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int prev0 = nums[0];
        int pos = 0, i = 1, size = nums.size();
        nums[pos] = prev0;
        pos += 1;
        int prev1 = -1;
        while (i < size) {
            if (pos == 0) {
                if (prev0 <= nums[i]) {
                    prev1 = prev0;
                    prev0 = nums[i];
                    i++;
                    pos++;
                }
            } else {
                if ((prev0 < nums[i] || prev1 != nums[i])) {
                    nums[pos] = nums[i];
                    prev1 = prev0;
                    prev0 = nums[i];
                    i++;
                    pos++;
                } else {
                    i++;
                }
            }
        }
        return pos;
    }
};