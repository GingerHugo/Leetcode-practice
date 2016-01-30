/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.Map.Entry;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Map<Integer, Interval> sortedIntervals = new TreeMap<Integer, Interval>();
        for (Interval interval : intervals) {
            if (sortedIntervals.containsKey(interval.start)) {
                int index = interval.start;
                sortedIntervals.put(index, sortedIntervals.get(index).end > interval.end ? sortedIntervals.get(index) : interval);
            }
            else sortedIntervals.put(interval.start, interval);
        }
        List<Interval> resultList = new LinkedList<>();
        Interval temp = null;
        for (Entry<Integer, Interval> interval : sortedIntervals.entrySet()) {
            if (temp == null) temp = interval.getValue();
            else {
                if (temp.end < interval.getValue().start) {
                    resultList.add(temp);
                    temp = interval.getValue();
                }
                else {
                    temp = new Interval(temp.start, Math.max(temp.end, interval.getValue().end));
                }
            }
        }
        if (temp != null) resultList.add(temp);
        return resultList;
    }
}