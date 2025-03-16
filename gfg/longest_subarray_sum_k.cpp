class Solution {
    public:
      int longestSubarray(vector<int>& arr, int k) {
          long long sum = 0;
          int count = INT_MIN;
          int size = arr.size();
          unordered_map<long long, int>mp;
          for(int i = 0;i<size;i++){
              sum += arr[i];
              if(sum == k){
                  count = max(count, i+1);
              }
              if(mp.find(sum) == mp.end()){
                  mp[sum] = i;
              }
              if(mp.find(sum-k) != mp.end()){
                  count = max(count, i- mp[sum-k]);
              }
          }
          return count == INT_MIN ? 0 : count;
      }
  };