public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> resultList = new ArrayList ();
        for (int i = 0; i < (1 << n); i++) {
            resultList.add(i ^ (i >> 1));   
        }
        return resultList;
    }
}