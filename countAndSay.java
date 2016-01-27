public class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        String result = "1";
        while (n-- > 1) {
            char[] cArr = result.toCharArray();
            StringBuilder sb = new StringBuilder();
            char pre = cArr[0];
            int count = 1;
            for (int i = 1; i < cArr.length; i++) {
                if (cArr[i] == pre) {
                    count++;
                } 
                else {
                    sb.append(count);
                    sb.append(pre);
                    pre = cArr[i];
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(pre);
            result = sb.toString();
        }
        return result;
    }
}