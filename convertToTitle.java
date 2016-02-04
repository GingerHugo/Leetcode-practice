public class Solution {
    public String convertToTitle(int n) {
        String[] table = new String[] {"Z", "A", "B", "C", "D",
        "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
        "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"}; 
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, table[n % 26]);
            n = (n - 1) / 26;
        }
        return sb.toString();
    }
}