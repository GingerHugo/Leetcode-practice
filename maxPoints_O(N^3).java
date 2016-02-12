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
    private boolean isCoLinear(Point i, Point j, Point k) {
        if ((i.x - j.x) * (k.y - j.y) == (i.y - j.y) * (k.x - j.x)) {
            return true;
        }
        return false;
    }

    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int result = 2;
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            // int count = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicate++;
                    result = Math.max(result, duplicate + 1);   //
                    continue;
                }
                int temp = 1;
                for (int k = j + 1; k < points.length; k++) {
                    if (isCoLinear(points[i], points[j], points[k])) {
                        temp++;
                    } 
                }
                // count = Math.max(temp, count);
                result = Math.max(result, temp + duplicate + 1);   // contain the point itself
            }
        }
        return result;
    }
}