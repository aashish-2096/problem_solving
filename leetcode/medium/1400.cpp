/**
Instead of finding how many cases it would work for, approach to find how many it won't work would do the stuff.
Finding how many odd char counts exists and handle accordingly
*/

class Solution {
public:
    bool canConstruct(string s, int k) {
        // vector<int> charInd(26, 0);
        // for (int i = 0; i < s.size(); i++) {
        //     charInd[s[i] - 'a'] += 1;
        // }
        // set<int> even, odd;
        // vector<int> evenArr(26, 0), oddArr(26, 0);
        // for (int i = 0; i < 26; i++) {
        //     if (charInd[i] % 2 == 0 && charInd[i] > 0) {
        //         evenArr[i] += charInd[i] / 2;
        //         even.insert(i);
        //     } else if (charInd[i] % 2 == 1 && charInd[i] > 0) {
        //         evenArr[i] += charInd[i] / 2;
        //         if (charInd[i] / 2 > 0) {
        //             even.insert(i);
        //         }
        //         oddArr[i] += 1;
        //         odd.insert(i);
        //     }
        // }
        // bool status = false;
        // cout << "EvenSize" << even.size() << "---" << odd.size() << endl;
        // if (k == s.size()) {
        //     return true;
        // } else if (k > s.size())
        //     return false;
        // else {
        //     if (even.size() >= k) {
        //         if (odd.size() <= k) {
        //             return true;
        //         }
        //     } else if (odd.size() == k) {
        //         return true;
        //     } else if ((odd.size() + even.size()) == k) {
        //         return true;
        //     } else if ((k > even.size() + odd.size() ||
        //                 k < even.size() + odd.size()) &&
        //                odd.size() <= k) {
        //         int oddSz = odd.size();
        //         while (oddSz > 0) {
        //             int y = (k - oddSz) % 2;
        //             if (y == 0) {
        //                 status = true;
        //                 break;
        //             } else {
        //                 oddSz--;
        //             }
        //         }
        //     }
        // }
        // return status;

        vector<int> charFreq(26, 0);
        int oddCount = 0;

        for (char ch : s) {
            charFreq[ch - 'a']++;
        }

        for (int freq : charFreq) {
            if (freq % 2 == 1) {
                oddCount++;
            }
        }
        return (k >= oddCount && k <= s.size());
    }
};