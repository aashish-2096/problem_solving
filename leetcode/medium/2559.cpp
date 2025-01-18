/**
- Prefix Sum building by marking the strings as vowels or not
- Range Queries by taking the actul bucket
 */

class Solution {
public:
    bool isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
    vector<int> vowelStrings(vector<string>& words,
                             vector<vector<int>>& queries) {
        int size = words.size();
        vector<int> prefixSum(size, 0);
        int vowelStrings = 0;
        vector<int> res;
        for (int i = 0; i < size; i++) {
            if (words[i].size() == 1 && isVowel(words[i][0])) {
                vowelStrings += 1;
            } else if (words[i].size() > 1) {
                int lastIndex = words[i].size() - 1;
                bool startEd =
                    isVowel(words[i][0]) && isVowel(words[i][lastIndex]);
                if (startEd)
                    vowelStrings += 1;
            }
            prefixSum[i] = vowelStrings;
        }
        
        for (auto query : queries) {
            int first = query[0];
            int second = query[1];
            if (first == 0) {
                res.push_back(prefixSum[second]);
            } else {
                int value = prefixSum[second] - prefixSum[first - 1];
                res.push_back(value);
            }
        }
        return res;
    }
};