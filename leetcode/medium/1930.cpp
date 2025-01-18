/**
Tack char using array ranges as small char array is only specified.
Get the difference based on match to find consider as palindrome.
 */

class Solution {
public:
    int countPalindromicSubsequence(string s) {
        int n = s.size();
        vector<int> first(26, -1), last(26, -1);
        for (int i = 0; i < n; ++i) {
            int idx = s[i] - 'a';
            if (first[idx] == -1)
                first[idx] = i;
            last[idx] = i;
        }

        int resultCount = 0;
        for (int ch = 0; ch < 26; ++ch) {
            if (first[ch] != -1 && last[ch] != -1 && first[ch] < last[ch]) {
                unordered_set<char> middleChars;
                for (int i = first[ch] + 1; i < last[ch]; ++i) {
                    middleChars.insert(s[i]);
                }
                resultCount += middleChars.size();
            }
        }
        return resultCount;
    }
};