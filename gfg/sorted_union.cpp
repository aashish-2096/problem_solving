// Union of 2 Sorted with Duplicates
// Can be done with two pointers for both arrays, and skipping usage of extra space.

class Solution {
    public:
      vector<int> findUnion(vector<int> &a, vector<int> &b) {
          set<int>st;
          for(auto i: a){
              st.insert(i);
          }
           for(auto i: b){
              st.insert(i);
          }
         vector<int> vt(st.begin(), st.end());
          return vt;
      }
  };