class Solution {
    public:
        int maxProfit(vector<int>& prices) {
            int minPrice = prices[0];
            int profit = 0;
            for(int i = 1;i<prices.size();i++){
                if(minPrice > prices[i]){
                    minPrice = prices[i];
                }
                int tempProfit = prices[i] - minPrice;
                profit = max(profit, tempProfit);
            }
            return profit;
        }
    };