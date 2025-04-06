class Solution {
    public:
        pair<int, int> expandAroundCenter(string &s, int left, int right) {
            while (left >= 0 && right < s.size() && s[left] == s[right]) {
                left--;
                right++;
            }
            return {left + 1, right - 1}; // Return the corrected indices
        }
    
        string longestPalindrome(string s) {
            if (s.empty()) return s;
            /**
            Cases considering if odd palindrome or even palindrome.
            **/
            int start = 0, maxLen = 0;
            for (int i = 0; i < s.size(); i++) {
                auto [left1, right1] = expandAroundCenter(s, i, i);
                if (right1 - left1 + 1 > maxLen) {
                    start = left1;
                    maxLen = right1 - left1 + 1;
                }
                auto [left2, right2] = expandAroundCenter(s, i, i + 1);
                if (right2 - left2 + 1 > maxLen) {
                    start = left2;
                    maxLen = right2 - left2 + 1;
                }
            }
            return s.substr(start, maxLen);
        }
    };
    