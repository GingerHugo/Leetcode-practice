public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> table = new HashSet<>();
        while (table.add(n)) {
            int m = 0;
            while (n > 0) {
                m += (n % 10) * (n % 10);
                n /= 10;
            }
            if (m == 1) {
                return true;
            }
            n = m;
        }
        return false;
    }
}