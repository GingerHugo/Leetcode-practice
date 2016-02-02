public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int lenght = prices.length;
    
        int[] leftProfit = new int[lenght];
        int leftMaxProfit = 0;
        int leftMin = prices[0];
        for (int i = 0; i < lenght; i++) {
            if (prices[i] < leftMin) leftMin = prices[i];
            if (prices[i] - leftMin > leftMaxProfit) leftMaxProfit = prices[i]-leftMin;
            leftProfit[i] = leftMaxProfit;
        }
        int maxProfit = 0;
        int rightMaxProfit = 0;
        int rightMax = prices[lenght-1];
        for (int i = lenght - 1; i >= 0; i--) {
            if (prices[i] > rightMax) rightMax = prices[i];
            if (rightMax - prices[i] > rightMaxProfit) rightMaxProfit = rightMax - prices[i];
            int currentProfit = rightMaxProfit + (i > 0 ? leftProfit[i-1] : 0);
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }
}