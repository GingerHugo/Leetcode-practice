/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> newList = new LinkedList<>();
        int i = 0;
        while (i < intervals.size()) {
            if (intervals.get(i).end < newInterval.start) {
                newList.add(intervals.get(i++));
            }
            else {
                break;
            }
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i++).end);
        }
        newList.add(newInterval);
        while (i < intervals.size()) {
            newList.add(intervals.get(i++));
        }
        return newList;
    }
}