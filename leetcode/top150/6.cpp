class Solution {
public:
    string convert(string str, int numRows) {
        if (numRows <= 1)
            return str;
        vector<string> st(numRows, "");
        int currentIndex = 0;
        int forward = 1;
        for (auto s : str) {
            st[currentIndex] += s;
            if ((currentIndex == numRows - 1 && forward > 0) ||
                (currentIndex == 0 && forward < 0)) {
                forward *= -1;
            }
            currentIndex += forward;
        }
        string res = "";
        for (auto s : st) {
            res += s;
        }
        return res;
    }
};