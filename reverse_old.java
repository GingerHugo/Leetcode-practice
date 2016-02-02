public class Solution {
    public int reverse(int x) {
        String temp = Integer.toString(x);
        String suffix = "";
        StringBuilder result = new StringBuilder();
        for (int i = temp.length() - 1; i >= 0; i--) {
            if (temp.charAt(i) != '-')
                result.append(temp.charAt(i));
            else suffix = "-";
        }
        temp = suffix + result.toString();
        System.out.println(temp);
        int returnValue = Integer.parseInt(temp);
        
        return returnValue;
    }
}