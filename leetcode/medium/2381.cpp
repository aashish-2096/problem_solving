/*
Get the mahnitude of shifts at each index, for this looping at all ranges start to end * string lenght would be TLE
Get ranged increment and use prefix sum to merge the end result. 
Good learning type problem
*/
class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        int n = s.size();
        vector<int> vt(n + 1, 0);
        for (auto s : shifts) {
            int dir = s[2] == 1 ? 1 : -1;
            vt[s[0]] += dir;
            vt[s[1] + 1] -= dir;
        }
        for (int i = 1; i < n+1; i++) {
            vt[i] += vt[i - 1];
        }
        string result;
        for (int i = 0; i < s.size(); i++) {
            int increment = (s[i] - 'a' + vt[i]) % 26;
            if (increment < 0) {
                increment += 26;
            }
            char ch = 'a' + increment;
            result += ch;
        }
        return result;
    }
};