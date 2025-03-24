class Solution {
    public:
        int duplicates(vector<int>& nums) {
            int slow = nums[0], fast = nums[0];
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
    
            slow = nums[0];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    
        int withExtraSpace(vector<int>& nums) {
            vector<int> vt(nums.size(), 0);
            int res = -1;
            for (auto i : nums) {
                vt[i] += 1;
                if (vt[i] > 1) {
                    res = i;
                    break;
                }
            }
            return res;
        }
        int findDuplicate(vector<int>& nums) { return duplicates(nums); }
    };