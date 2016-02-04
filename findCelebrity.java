/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n == 1) {
            return -1;
        }
        Set<Integer> nonCelebrity = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nonCelebrity.contains(i)) {
                    if (knows(j, i)) {
                        nonCelebrity.add(j);
                    }
                    else if (!knows(i, j)) {
                        nonCelebrity.add(j);
                    }
                }
                else {
                    if (knows(i, j)) {
                        nonCelebrity.add(i);
                        if (knows(j, i)) {
                            nonCelebrity.add(j);
                        }
                    }
                    else {
                        if (!knows(j, i)) {
                            nonCelebrity.add(i);
                            nonCelebrity.add(j);
                        }
                        else {
                            nonCelebrity.add(j);
                        }
                    }
                }
                if (nonCelebrity.size() == n) {
                    return -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!nonCelebrity.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}