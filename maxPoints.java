/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    private int getGCD(int i, int j) {
        if (j == 0) {
            return i;
        }
        return getGCD(j, i % j);
    }

    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int result = 0;
        Map<Integer, Map<Integer, Integer>> table = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            table.clear();
            int overlap = 0;
            int maxNum = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = getGCD(x, y);
                if (gcd != 0) { // x or y can either be zero
                    x /= gcd;
                    y /= gcd;
                }
                if (x * y < 0 && x < 0) {
                    x = -x;
                    y = -y;
                }
                if (!table.containsKey(x)) {
                    Map<Integer, Integer> temp = new HashMap<>();
                    table.put(x, temp);
                }
                if (!table.get(x).containsKey(y)) {
                    table.get(x).put(y, 0);
                }
                table.get(x).put(y, table.get(x).get(y) + 1);
                maxNum = Math.max(maxNum, table.get(x).get(y));
            }
            result = Math.max(result, maxNum + overlap + 1);
        }
        return result;
    }
}