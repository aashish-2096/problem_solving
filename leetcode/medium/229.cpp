class Solution {
    public:
        vector<int> majorityElement(vector<int>& nums) {
            int n = nums.size();
            int count = 1 + (n / 3);
            cout << count << endl;
            unordered_map<int, int> mp;
            set<int> res;
            for (auto i : nums) {
                if (mp.find(i) == mp.end())
                    mp[i] = 0;
                mp[i] += 1;
                if (mp[i] >= count) {
                    res.insert(i);
                }
            }
            return vector<int>(res.begin(), res.end());
        }
    };