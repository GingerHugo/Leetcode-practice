public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        HashMap<String, List<String>> table = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] cTemp = strs[i].toCharArray();
            Arrays.sort(cTemp);
            // String sTemp = cTemp.toString(); // Does not work
            // String sTemp = String.valueOf(cTemp); // work!
            String sTemp = new String(cTemp); // work!
            if (!table.containsKey(sTemp))
                table.put(sTemp, new LinkedList<>());
            table.get(sTemp).add(strs[i]);
        }
        // for(String key: map.keySet())
        return new LinkedList<List<String>> (table.values());
    }
}