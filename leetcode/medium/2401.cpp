class Solution {
    public:
        int longestNiceSubarray(vector<int>& nums) {
            int maxLen = 1;
            int currentIndex = 0, size = nums.size(), startIndex = 0;
            while (currentIndex < size - 1) {
                bool isZero = true;
                int numToCheck = nums[currentIndex + 1];
                int start = startIndex;
                while (start <= currentIndex) {
                    if ((nums[start] & numToCheck) == 0) {
                        isZero = true;
                        start++;
                    } else {
                        isZero = false;
                        startIndex++;
                        start = startIndex;
                        break;
                    }
                }
                if (isZero) {
                    int updatedIndex = currentIndex - startIndex + 2;
                    maxLen = max(maxLen, updatedIndex);
                    currentIndex++;
                }
            }
            return maxLen;
        }
    };