class Solution {
public:
    bool checkEqual(string s1, string s2) {
        bool status = true;
        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] != s2[i])
                status &= false;
        }
        return status;
    }

    int countPrefixSuffixPairs(vector<string>& words) {
        int pairsOfSuffix = 0;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i < j && words[i].size() <= words[j].size()) {
                    string s1 = words[i];
                    string s2 = words[j];
                    reverse(s1.begin(), s1.end());
                    reverse(s2.begin(), s2.end());
                    if (checkEqual(words[i], words[j]) && checkEqual(s1, s2)) {
                        pairsOfSuffix += 1;
                    }
                }
            }
        }
        return pairsOfSuffix;
    }
};