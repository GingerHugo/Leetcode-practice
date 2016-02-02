public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        else if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution test = new Solution();
        String hay = "missipi";
        String need = "pi";
        System.out.println(test.strStr(hay, need));
    }
}