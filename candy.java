public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int numIncrem = 1;
        int numDecrem = 0;
        int numPeak = ratings.length + 1;
        int result = 0;
        if (ratings[0] < ratings[1]) {
            result += numIncrem;
            // numIncrem++;
        }
        else if (ratings[0] > ratings[1]) {
            numDecrem++;
            result += numDecrem;
        }
        else {
            result += 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                numIncrem++;
                result += numIncrem;
                numPeak = numIncrem;
                if (numDecrem != 0) {
                    numDecrem = 0;
                }
            }
            else if (ratings[i - 1] > ratings[i]) {
                numDecrem++;
                result += numDecrem;
                if (numIncrem != 1) {
                    numIncrem = 1;
                }
                if (numPeak <= numDecrem) {
                    result += 1;
                }
            }
            else {
                numDecrem = 1;
                numIncrem = 1;
                result += 1;
                numPeak = ratings.length + 1;
            }
        }
        return result;
    }
}