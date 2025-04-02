class Solution {
    public:
        bool isPalindrome(string s, int low, int high) {
            bool status = true;
            while (low < high) {
                if (s[low++] != s[high--]) {
                    status *= false;
                    break;
                }
            }
            return status;
        }
    
        void splitAndCheck(string& s, int index, vector<string> res,
                           vector<vector<string>>& result) {
            if (s.size() == index) {
                result.push_back(res);
                return;
            }
    
            for (int i = index; i < s.size(); i++) {
                string sub = s.substr(index, i - index + 1);
                if (isPalindrome(s, index, i)) {
                    res.push_back(sub);
                    splitAndCheck(s, i + 1, res, result);
                    res.pop_back();
                }
            }
        }
        vector<vector<string>> partition(string s) {
            vector<vector<string>> result;
            vector<string> res;
            splitAndCheck(s, 0, res, result);
            return result;
        }
    };