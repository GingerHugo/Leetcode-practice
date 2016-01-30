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
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval> () {
            public int compare(Interval a, Interval b) { return a.start - b.start;}
        });
        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            while(!queue.isEmpty() && intervals[i].start >= queue.peek())
                queue.poll();
            queue.add(intervals[i].end);
            result = Math.max(result, queue.size());
        }
        return result;
    }
}