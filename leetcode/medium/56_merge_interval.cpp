class Solution {
    public:
        vector<vector<int>> merge(vector<vector<int>>& interval) {
            sort(interval.begin(), interval.end());
            vector<vector<int>> res;
            int low = interval[0][0];
            int high = interval[0][1];
            for (int i = 1; i < interval.size(); i++) {
                if (high >= interval[i][0]) {
                    if (interval[i][1] > high)
                        high = interval[i][1];
                } else if (high < interval[i][0]) {
                    vector<int> tp({low, high});
                    res.push_back(tp);
                    low = interval[i][0];
                    high = interval[i][1];
                }
            }
            vector<int> tp({low, high});
            res.push_back(tp);
            return res;
        }
    };

    // Cleaner Version
    class Solution {
        public:
            vector<vector<int>> merge(vector<vector<int>>& interval) {
                sort(interval.begin(), interval.end());
                vector<vector<int>> res;
                res.push_back(interval[0]);
                for (int i = 1; i < interval.size(); i++) {
                    if (res.back()[1] >= interval[i][0]) {
                        if (interval[i][1] > res.back()[1])
                            res.back()[1] = max(res.back()[1], interval[i][1]);
                    } else {
                        res.push_back(interval[i]);
                    }
                }
                return res;
            }
        };