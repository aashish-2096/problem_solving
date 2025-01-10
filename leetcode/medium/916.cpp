/**
- Observe test cases and ask. 
- Maintain the global count of max char and map against each word.
*/
class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        vector<string>result;
        vector<int> index(26, 0);
        for (int i = 0; i < words2.size(); i++) {
            vector<int> cr(26, 0);
            for (char ch : words2[i]) {
                cr[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                index[i] = max(cr[i], index[i]);
            }
        }
        for (auto word : words1) {
            vector<int> localIndex(26, 0);
            set<char> chr;
            for (char wrd : word) {
                localIndex[wrd - 'a'] += 1;
                chr.insert(wrd);
            }
            bool status = true;
            for (int i = 0; i < 26; i++) {
                if (localIndex[i] < index[i]) {
                    status = false;
                    break;
                }
            }
            if (status) {
                result.push_back(word);
            }
        }
        return result;
    }
};