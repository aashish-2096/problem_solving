class Solution {
    public:
        int subarraySum(vector<int>& nums, int k) {
            unordered_map<int, int> mp;
            int count = 0;
            long long prefixSum = 0;
            mp[0] = 1;
            for (int i = 0; i < nums.size(); i++) {
                prefixSum += nums[i];
                if (mp.find(prefixSum - k) != mp.end()) {
                    count += mp[prefixSum - k];
                }
                mp[prefixSum] += 1;
            }
            return count;
        }
    };