public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        else if (prices.length == 2) {
            return (prices[1] > prices[0]) ? (prices[1] - prices[0]) : 0;
        }
        else {
            int minPrice = (prices[1] > prices[0]) ? prices[0] : prices[1];
            int deltaPrice = (prices[1] > prices[0]) ? (prices[1] - prices[0]) : 0;
            int totalProfit = 0;
            for (int i = 2; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    deltaPrice = prices[i] - minPrice;
                }
                else {
                    minPrice = prices[i];
                    totalProfit += deltaPrice;
                    deltaPrice = 0;
                }
            }
            totalProfit += deltaPrice;
            return totalProfit;
        }
    }
}