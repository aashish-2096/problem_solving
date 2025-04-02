class Solution {
    public:
        string getPendingItems(string str, int index) {
            string pend = "";
            for (int i = 0; i < str.size(); i++) {
                if (i != index) {
                    pend += str[i];
                }
            }
            return pend;
        }
        string getNthPerm(string str, int k, vector<int>& factorial) {
            int strsize = str.size();
            if (k <= 1)
                return str;
            if (strsize == 2 && k == 2) {
                reverse(str.begin(), str.end());
                return str;
            }
            int size = str.size();
            int val = factorial[size - 1];
            int nextInd = int(k / val);
            int nextPos = int(k % val);
            if (nextPos == 0) {
                nextPos = val;
                nextInd--;
            }
            string currentRes(1, str[nextInd]);
            string pendingItems = getPendingItems(str, nextInd);
            string res = getNthPerm(pendingItems, nextPos, factorial);
            return currentRes + res;
        }
        string getPermutation(int n, int k) {
            string res = "";
            vector<int> factorial;
            long long prod = 1;
            factorial.push_back(1);
            for (int i = 1; i <= n; i++) {
                prod *= i;
                factorial.push_back(prod);
                res += to_string(i);
            }
            return getNthPerm(res, k, factorial);
        }
    };