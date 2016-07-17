/*
Given a data stream input of non-negative integers a1, a2, ..., an, ..., 
summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
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
public class SummaryRanges {
    
    private List<Interval> res;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        res = new ArrayList<Interval>();
    }
    
    public void addNum(int val) {
        if(res.isEmpty()) {
            res.add(new Interval(val, val));
        } else {
            List<Interval> list = new ArrayList<Interval>();
            Interval newInter = new Interval(val, val);
            for(int i=0; i<res.size(); i++) {
                Interval cur = res.get(i);
                if(newInter.end < cur.start-1) {
                    list.add(newInter);
                    newInter = cur;
                } else if(newInter.start > cur.end+1) {
                    list.add(cur);
                    continue;
                } else if(newInter.end >= cur.start-1 || cur.end >= newInter.start-1) {
                    newInter.start = Math.min(newInter.start, cur.start);
                    newInter.end = Math.max(newInter.end, cur.end);
                }
            }
            list.add(newInter);
            res = list;
        }
    }

    public List<Interval> getIntervals() {
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
