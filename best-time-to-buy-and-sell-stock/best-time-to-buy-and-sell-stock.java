class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(profit < prices[i] - minPrice){
                profit = prices[i] - minPrice;
            }

            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }
        return profit;
    }
}