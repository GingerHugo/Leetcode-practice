import java.lang.*;
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        else if (prices.length == 2) {
            return (prices[0] < prices[1]) ? (prices[1] - prices[0]) : 0;
        }
        else {
            int minPrice = (prices[0] < prices[1]) ? prices[0] : prices[1];
            int maxPrice = (prices[0] < prices[1]) ? prices[1] : prices[0];
            int minPriceSec = maxPrice;
            int margin = (prices[0] < prices[1]) ? (prices[1] - prices[0]) : 0;
            int gap = 0;
            int flag = 0;
            for (int i = 2; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    if (maxPrice != minPriceSec) {
                        gap = Math.max(Math.min(maxPrice, prices[i]) - minPriceSec, gap);
                    }
                    if ((prices[i] - minPrice) > margin) {
                        maxPrice = prices[i];
                        minPriceSec = maxPrice;
                        if (flag == 1) {
                            gap = Math.max(margin, gap);
                            flag = 0;
                        }
                        margin = maxPrice - minPrice;
                    }
                    else if (flag == 1) {
                        gap = Math.max((prices[i] - minPrice), gap);
                        // flag = 0;
                    }
                }
                else {
                    if (prices[i] < minPrice) {
                        minPrice = prices[i];
                        flag = 1;
                        maxPrice = minPrice;
                        minPriceSec = minPrice;
                    }
                    else if (prices[i] < minPriceSec) {
                        minPriceSec = prices[i];
                    }
                }
            }
            return (margin + gap);
        }
    }
}