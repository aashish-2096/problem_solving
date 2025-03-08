class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int size = nums.size();
        if (k > size) {
            k = k % size;
        }
        int first = 0, last = size - k - 1;
        while (first < last) {
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
        first = size - k;
        last = size - 1;
        while (first < last) {
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
        reverse(nums.begin(), nums.end());
    }
};