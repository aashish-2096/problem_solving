
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() >= 2) {
            string s1 = strs[0];
            string s2 = strs[1];
            int minSize = min(s1.size(), s2.size());
            string res = "";
            for (int i = 0; i < minSize; i++) {
                if (s1[i] == s2[i]) {
                    res += s1[i];
                } else {
                    break;
                }
            }
            if (strs.size() == 2)
                return res;
            for (int i = 2; i < strs.size(); i++) {
                string temp = "";
                for (int j = 0; j < res.size(); j++) {
                    if (strs[i][j] == res[j]) {
                        temp += res[j];
                    } else {
                        res = temp;
                        break;
                    }
                }
            }
            return res;
        }
        return strs[0];
    }
};