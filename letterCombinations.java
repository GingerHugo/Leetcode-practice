public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null) return null;
        String[] table = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> result = new LinkedList<>();
        if (digits.length() == 0) return result;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String temp = result.remove();
                for (char c : table[num].toCharArray()) {
                    result.add(temp + c);
                }
            }
        }
        return result;
    }
}