/**
Pattern Identification amogst the result
After each deletion remaining numbers are expected.
*/

class Solution {
public:
    int minimumLength(string s) {
        vector<int> index(26, 0);
        for (auto i : s) {
            index[i - 'a'] += 1;
        }
        int minLength = 0;
        for (int i = 0; i < 26; i++) {
            if (index[i] > 0 && index[i] % 2 == 0)
                minLength += 2;
            else if (index[i] % 2 == 1)
                minLength += 1;
        }
        return minLength;
    }
};