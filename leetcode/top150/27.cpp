class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int i = 0, pos = 0;
        int size = nums.size();
        while(i < size){
            if(nums[i] == val){
                i++;
            } else {
                nums[pos] = nums[i];
                i++;
                pos++;
            }
        }
        return pos;
    }
};