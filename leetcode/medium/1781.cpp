class Solution {
    public:
        int beautySum(string str) {
            int sum = 0, count = 0;
            for (int i = 0; i < str.size(); i++) {
                vector<int> vt(26, 0);
                multiset<int> st;
                for (int j = i; j < str.size(); j++) {
                    int index = str[j] - 'a';
                    if (vt[index] > 0) {
                        st.erase(st.find(vt[index]));
                    }
                    vt[index] += 1;
                    st.insert(vt[index]);
                    sum += (*st.rbegin() - *st.cbegin());
                }
            }
            return sum;
        }
    };