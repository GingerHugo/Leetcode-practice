public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        else if (prices.length == 2) {
            return (prices[1] > prices[0]) ? (prices[1] - prices[0]) : 0;
        }
        else {
            // int maxPrice = (prices[1] > prices[0]) ? prices[1] : prices[0];
            int minPrice = (prices[1] > prices[0]) ? prices[0] : prices[1];
            int deltaPrice = (prices[1] > prices[0]) ? (prices[1] - prices[0]) : 0;
            for (int i = 2; i < prices.length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                }
                // else if (prices[i] > maxPrice) {
                //     maxPrice = prices[i];
                //     deltaPrice = (maxPrice > minPrice) ? (maxPrice - minPrice) : 0; 
                // }
                else {
                    int iTemp = prices[i] - minPrice;
                    if (iTemp > deltaPrice) {
                        deltaPrice = iTemp;
                    }
                }
            }
            return deltaPrice;
        }
    }
}