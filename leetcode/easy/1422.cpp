/*
- Using two pointers approach. 
- Compute the total sum and increment left on '0' and decrement right on '1'
- Iterate while index reaches second last entry
*/
class Solution {
public:
    int maxScore(string s) {
        int totalSum = 0;
        int maxSum = INT_MIN;
        int left = 0, right = 0;
        if (s.size() > 1) {
            for (int i = 1; i < s.size(); i++) {
                if (s[i] == '1') {
                    totalSum += 1;
                }
            }
        }

        if (s[0] == '0') {
            left = 1;
        }
        right = totalSum;
        maxSum = max(maxSum, (left + right));
        int index = 1;
        while (index < s.size()-1) {
            if (s[index] == '0') {
                left++;
            } else {
                right--;
            }
            maxSum = max(maxSum, (left + right));
            index++;
        }
        return maxSum;
    }
};