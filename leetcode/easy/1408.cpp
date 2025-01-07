/**
O(N^2) loop checking 
*/
class Solution {
public:
    vector<string> stringMatching(vector<string>& words) {
        set<string> res;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i != j && words[i].size() < words[j].size()) {
                    if (words[j].find(words[i]) != string::npos) {
                        res.insert(words[i]);
                    }
                }
            }
        }
        vector<string> v(res.begin(), res.end());
        return v;
    }
};