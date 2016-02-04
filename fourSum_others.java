public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);

        Map<Integer, List<Integer>> twoSumMap = new HashMap<>(); // for holding visited pair sums. All pairs with the same pair sum are grouped together
        Set<List<Integer>> res = new HashSet<>();  // for holding the results

        for (int i = 0; i < num.length; i++) {
            // get rid of repeated pair sums
            if (i > 1 && num[i] == num[i - 2]) {
                continue;
            }

            for (int j = i + 1; j < num.length; j++) {
                // get rid of repeated pair sums
                if (j > i + 2 && num[j] == num[j - 2]) {
                    continue;
                }

                // for each pair sum, check if the pair sum that is needed to get the target has been visited.              
                if (twoSumMap.containsKey(target - (num[i] + num[j]))) {   
                    // if so, get all the pairs that contribute to this visited pair sum.
                    List<Integer> ls = twoSumMap.get(target - (num[i] + num[j]));

                    for (int k : ls) {
                        // we have two pairs: one is indicated as (k / num.length, k % num.length), the other is (i, j).
                        // we first need to check if they are overlapping with each other.
                        int m1 = Math.min(k / num.length, i);  // m1 will always be the smallest index
                        int m2 = Math.min(k % num.length, j);  // m2 will be one of the middle two indices
                        int m3 = Math.max(k / num.length, i);  // m3 will be one of the middle two indices
                        int m4 = Math.max(k % num.length, j);  // m4 will always be the largest index

                        if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4) {
                            continue;  // two pairs are overlapping, so just ignore this case
                        } else {       // else record the result
                            if (m2 > m3) {
                                res.add(Arrays.asList(num[m1], num[m3], num[m2], num[m4]));
                            } else {
                                res.add(Arrays.asList(num[m1], num[m2], num[m3], num[m4]));
                            }
                        }
                    }
                }

                // mark that we have visited current pair and add it to the corrsponding pair sum group.
                // here we've encoded the pair indices i and j into one integer.
                if (!twoSumMap.containsKey(num[i] + num[j])) {
                    List<Integer> ls = new ArrayList<>();
                    twoSumMap.put(num[i] + num[j], ls);
                }
                twoSumMap.get(num[i] + num[j]).add(i * num.length + j);
            }
        }

        return new ArrayList<List<Integer>>(res);
    }
}