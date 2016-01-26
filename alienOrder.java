public class Solution {
    private boolean buildTable(char a, char b, HashMap<Character, Set<Character>> table, 
    int[] inLink) {
        if (a == b) return true;
        Set<Character> temp = table.get(a);
        if (temp != null) {
            if (temp.contains(b)) return false;
            temp.add(b);
        }
        else {
            Set<Character> temp2 = new HashSet<>();
            temp2.add(b);
            table.put(a, temp2);
        }
        inLink[b - 'a']++;
        return false;
    }

    private void buildGraph(String[] words, int[] inLink, HashSet<Character> letterSet, 
    HashMap<Character, Set<Character>> table) {
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                letterSet.add(words[i].charAt(j));
                if (i == 0 || j >= words[i - 1].length() || !flag) continue;
                flag = buildTable(words[i - 1].charAt(j), words[i].charAt(j), table, inLink);
            }
        }    
    }

    public String alienOrder(String[] words) {
        int[] inLink = new int[26];
        HashMap<Character, Set<Character>> table = new HashMap<>();
        HashSet<Character> letterSet = new HashSet<>();
        
        buildGraph(words, inLink, letterSet, table);
        Queue<Character> candidate = new LinkedList<>();
        for (char letter : letterSet) {
            if (inLink[letter - 'a'] == 0)
                candidate.add(letter);    // Offer: add; Poll: remove
        }
        StringBuilder result = new StringBuilder();
        while (!candidate.isEmpty()) {
            char a = candidate.remove();
            result.append(a);
            Set<Character> temp = table.get(a);
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