public class Solution {
    private void buildTable(String word, int[] inLink, HashSet<Character> letterSet, 
        HashMap<Character, List<Character>> table) {
        char[] charArr = word.toCharArray();
        letterSet.add(charArr[0]);
        for (int i = 0; i < charArr.length - 1; i++) {
            // Incorrect: bacteria, a < b!!
            if (charArr[i] == charArr[i + 1]) continue;
            letterSet.add(charArr[i + 1]);
            if (table.containsKey(charArr[i]))
                table.get(charArr[i]).add(charArr[i + 1]);
            else {
                List<Character> temp = new LinkedList<>();
                temp.add(charArr[i + 1]);
                table.put(charArr[i], temp);
            }
            inLink[charArr[i + 1] - 'a']++;
        }
    }

    public String alienOrder(String[] words) {
        int[] inLink = new int[26];
        HashMap<Character, List<Character>> table = new HashMap<>();
        HashSet<Character> letterSet = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.charAt(0));
            buildTable(word, inLink, letterSet, table);
        }
        buildTable(result.toString(), inLink, letterSet, table);
        Queue<Character> candidate = new LinkedList<>();
        for (char letter : letterSet) {
            if (inLink[letter - 'a'] == 0)
                candidate.add(letter);    // Offer: add; Poll: remove
        }
        result.setLength(0);
        while (!candidate.isEmpty()) {
            char a = candidate.remove();
            // System.out.println(a);
            result.append(a);
            List<Character> temp = table.get(a);
            if (!table.containsKey(a)) continue;
            for (char letter : temp) {
                inLink[letter - 'a']--;
                if (inLink[letter - 'a'] == 0)
                    candidate.add(letter);
            }
        }
        if (result.length() != letterSet.size())
            return "";
        else
            return result.toString();
    }
}