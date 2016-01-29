import java.math.BigInteger;

public class Solution {
    private boolean isValid(BigInteger num1, BigInteger num2, int index, String num) {
        if (index == num.length()) return true;
        num2 = num2.add(num1);
        num1 = num2.subtract(num1);     //subtract
        String temp = num2.toString();
        return (num.startsWith(temp, index)) && isValid(num1, num2, index + temp.length(), num);
    }

    public boolean isAdditiveNumber(String num) {
        int n = num.length();   // Not size()!
        for (int i = 1; i <= n / 2; i++) {
            BigInteger num1 = new BigInteger(num.substring(0, i));
            if (num.charAt(0) == '0' && i > 1) break;    // Number 0 case of first sequence
            for (int j = 1; Math.max(i,j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) break;    // Number 0 case of second sequence
                BigInteger num2 = new BigInteger(num.substring(i, i + j));
                if (isValid(num1, num2, i + j, num)) return true;
            }
        }
        return false;
    }
}