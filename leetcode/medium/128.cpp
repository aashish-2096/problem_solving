class Solution {
    public:
        int longestConsecutive(vector<int>& nums) {
            if (nums.size() <= 1)
                return nums.size();
            multimap<int, int> mp;
            for (auto num : nums) {
                mp.insert({num, 1});
            }
            int size = 0;
            int currentSize = 0, prev = INT_MIN;
            int count = 0;
            for (auto m : mp) {
                count += 1;
                if (prev == INT_MIN) {
                    currentSize += 1;
                    prev = m.first;
                    size = max(size, currentSize);
                } else {
                    int diff = abs(m.first - prev);
                    if (diff == 1) {
                        currentSize += 1;
                        size = max(size, currentSize);
                        prev = m.first;
                    } else if (diff == 0) {
                        continue;
                    } else {
                        size = max(size, currentSize);
                        currentSize = 1;
                        prev = m.first;
                    }
                }
            }
            return size;
        }
    };