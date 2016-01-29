public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                char[] c1 = a.toCharArray();
                char[] c2 = b.toCharArray();
                int n = Math.min(c1.length, c2.length);
                for (int i = 0; i < n; i++)
                    if (c1[i] != c2[i])
                        return c1[i] - c2[i];
                if (c1.length == c2.length) return 0;
                else if (c1.length > c2.length) return 1;    
                else return -1;
            }
        });
        HashMap<Integer, List<String>> table = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] cTemp = strs[i].toCharArray();
            int iTemp = 0;
            for (char c : cTemp)
                iTemp += c - 'a';
            if (cTemp.length == 0) iTemp = -1;
            if (table.containsKey(iTemp))
                table.get(iTemp).add(strs[i]);
            else {
                List<String> temp = new LinkedList<>();
                temp.add(strs[i]);
                table.put(iTemp, temp);
            }
        }
        List<List<String>> result = new LinkedList<List<String>>();
        for (Map.Entry<Integer, List<String>> e : table.entrySet())
            result.add(e.getValue());
        return result;
    }
}