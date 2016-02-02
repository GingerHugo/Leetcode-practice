public class Solution {
    private void parseStringToInt(String numString, int[] numArray) {
        for (int i = 0; i < numString.length(); i++) {
            numArray[i] = Integer.parseInt(String.valueOf(numString.charAt(i)));
        }
    }
    private String convertNumToString (int[] numArray) {
        StringBuilder builderTemp = new StringBuilder(numArray.length);
        int flagInt = 1;
        for (int i : numArray) {
            if (flagInt && i == 0) {
                continue;
            }
            else {
                flagInt = 0;
                builderTemp.append(i);
            }
        }
        if (builderTemp.length() == 0) {
            builderTemp.append(0);
        }
        return builderTemp.toString();
    }
    public String multiply(String num1, String num2) {
        int[] a = new int[num1.length()];
        int[] b = new int[num2.length()];
        int[] c = new int[num1.length() + num2.length() + 2];
        parseStringToInt(num1, a);
        parseStringToInt(num2, b);
        for (int i = 0; i < a.length; i++) {
            int indexMulti1 = a.length - i - 1;
            int inNum = 0;
            int reNum;
            for (int j = 0; j < b.length; j++) {
                int indexMulti2 = b.length - j - 1;
                int indexMulti3 = c.length - j - i - 1;
                reNum = (a[indexMulti1] * b[indexMulti2] + inNum) % 10;
                inNum = (a[indexMulti1] * b[indexMulti2] + inNum) / 10;
                inNum += (c[indexMulti3] + reNum) / 10;
                c[indexMulti3] = (c[indexMulti3] + reNum) % 10;
            }
            c[c.length - b.length - i - 1] += inNum;
        }
        return convertNumToString(c);
    }
}