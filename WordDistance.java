public class WordDistance {
    private Map<String, List<Integer>> table = new HashMap<>();
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!table.containsKey(words[i])) {
                table.put(words[i], new ArrayList<>());
            }
            table.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> listA = table.get(word1);
        List<Integer> listB = table.get(word2);
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < listA.size(); i++) {
            for (int j = 0; j < listB.size(); j++) {
                // int temp = listA.get(i) - listB.get(j);
                // count = Math.min(count, listA.get(i) > listB.get(j) ? temp : -temp);
                count = Math.min(count, Math.abs(listA.get(i) - listB.get(j)));
            }
        }
        return count;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");