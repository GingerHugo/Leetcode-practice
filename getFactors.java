public class Solution {
    private List<List<Integer>> getFactor(int n, int start) {
        List<List<Integer>> result = new LinkedList<>();
        int end = (int) Math.sqrt(n);
        for (int i = start; i <= end; i++) {
            if (n % i != 0) {
                continue;
            }
            List<Integer> temp = new LinkedList();
            temp.add(i);
            temp.add(n / i);
            result.add(temp);
            List<List<Integer>> pres = getFactor(n / i, i);
            for (List<Integer> pre : pres) {
                pre.add(0, i);
            }
            result.addAll(pres);
        }
        return result;
    }
    public List<List<Integer>> getFactors(int n) {
        return getFactor(n, 2);
    }
}