/**
Check for presence and and char match.
*/
class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int index = 0;
        int prevSize = pref.size() - 1;
        for (int i = 0; i < words.size(); i++) {
            if (words[i].find(pref) != string::npos && pref[0] == words[i][0] &&
                pref[prevSize] == words[i][prevSize]) {
                index += 1;
            }
        }
        return index;
    }
};