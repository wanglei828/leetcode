/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        Interval cur=intervals.get(0);
        for(int i=1; i<intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            if(cur.end < tmp.start) {
                res.add(cur);
                cur = tmp;
            } else {
                cur.end = Math.max(cur.end, tmp.end);
            } 
        }
        res.add(cur);
        return res;
    }
}
