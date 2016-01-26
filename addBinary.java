public class Solution {
    public String addBinary(String a, String b) {
        int incre = 0;
        int i, j; 
        i = a.length() - 1; 
        j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i >= 0) incre += a.charAt(i--) - '0';
            if (j >= 0) incre += b.charAt(j--) - '0';
            result.append(incre % 2);
            incre /= 2;
        }
        if(incre != 0) result.append(incre);
        return result.reverse().toString();
    }
}