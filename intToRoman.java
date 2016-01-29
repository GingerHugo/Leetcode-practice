public class Solution {
    public String intToRoman(int num) {
        StringBuilder sbResult = new StringBuilder();
        int kiloDigit = num / 1000;
        num = num % 1000;
        if (kiloDigit != 0) {
            for (int i = 0; i < kiloDigit; i++) {
                sbResult.append("M");
            }
        }
        int hundredDigit = num / 100;
        num = num % 100;
        if (hundredDigit == 9) {
            sbResult.append("CM");
            hundredDigit = 0;
        }
        else if (hundredDigit == 4) {
            sbResult.append("CD");
            hundredDigit = 0;
        }
        else if (hundredDigit >= 5) {
            sbResult.append("D");
            hundredDigit -= 5;
        }
        for (int i = 0; i < hundredDigit; i++) {
            sbResult.append("C");
        }
        int deciDigit = num / 10;
        num = num % 10;
        if (deciDigit == 9) {
            sbResult.append("XC");
            deciDigit = 0;
        }
        else if (deciDigit == 4) {
            sbResult.append("XL");
            deciDigit = 0;
        }
        else if (deciDigit >= 5) {
            sbResult.append("L");
            deciDigit -= 5;
        }
        for (int i = 0; i < deciDigit; i++) {
            sbResult.append("X");
        }
        if (num == 9) {
            sbResult.append("IX");
            num = 0;
        }
        else if (num == 4) {
            sbResult.append("IV");
            num = 0;
        }
        else if (num >= 5) {
            sbResult.append("V");
            num -= 5;
        }
        for (int i = 0; i < num; i++) {
            sbResult.append("I");
        }
        return sbResult.toString();
    }
}