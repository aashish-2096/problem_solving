class Solution {
    public:
        int minimumOperations(vector<int>& nums) {
            int correctIndex = -1;
            vector<int> index(101, 0);
            for (int i = nums.size() - 1; i >= 0; i--) {
                if (index[nums[i]] != 0) {
                    break;
                } else {
                    correctIndex = i;
                    index[nums[i]] = 1;
                }
            }
            if (correctIndex == 0)
                return 0;
            int val = 0;
            if (correctIndex > 0) {
                val += (correctIndex / 3);
                if (correctIndex % 3 != 0) {
                    val += 1;
                }
            }
            return val;
        }
    };