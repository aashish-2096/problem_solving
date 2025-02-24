class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        unordered_map<int,int>mp;
        int pos = 0, i = 0, size = nums.size();
        while(i< size){
            if(mp.find(nums[i]) == mp.end()){
                nums[pos] = nums[i];
                mp[nums[i]] = 1;
                i++;
                pos++;
            } else {
                i++;
            }
        }
        return pos;
    }
};