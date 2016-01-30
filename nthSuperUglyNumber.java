public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        int[] numbers = new int[n];
        numbers[0] = 1;
        for (int i = 1; i < n; i++) {
            numbers[i] = Integer.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                numbers[i] = Math.min(numbers[i], primes[j] * numbers[index[j]]);
            }

            for (int j = 0; j < primes.length; j++) {
                if (numbers[i] == primes[j] * numbers[index[j]]) {
                    index[j]++;
                }
            }
        }
        return numbers[n - 1];
    }
}