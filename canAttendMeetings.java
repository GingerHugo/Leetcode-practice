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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) return false;
        // lamda expression
        // Arrays.sort(intervals, (a, b) -> a.start - b.start);
        Arrays.sort(intervals, new Comparator<interval>() {
        public int compare(interval a, interval b) {return a.start - b.start;} 
        // Must use public and compare
        });
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i].start < intervals[i - 1].end)
                return false;
        return true;
    }
}