/*
We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. 
For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  
Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

 

Example 1:

Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation: There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
Example 2:

Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
 

Constraints:

1 <= schedule.length , schedule[i].length <= 50
0 <= schedule[i].start < schedule[i].end <= 10^8
*/

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<List<Interval>> freetime = new ArrayList<>();
        for (List<Interval> list : schedule) {
            List<Interval> ft = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Interval inter = list.get(i);
                if (i == 0) {
                    Interval newInter = new Interval(Integer.MIN_VALUE, inter.start);
                    ft.add(newInter);
                } else {
                    if (inter.start - list.get(i-1).end >=1) {
                        Interval newInter = new Interval(list.get(i-1).end, inter.start);
                        ft.add(newInter);
                    }
                }
                if ( i == list.size() - 1) {
                    Interval newInter = new Interval(inter.end, Integer.MAX_VALUE);
                    ft.add(newInter);
                }
            }
            freetime.add(ft);
        }
        List<Interval> res = freetime.get(0);
        List<Interval> ft0 = freetime.get(0); 
        for (int i = 1; i < freetime.size(); i++) {
            res = new ArrayList<>();
            getShared(ft0, freetime.get(i), res);
            ft0 = res;
        }
        if (res.size() > 0) {
            Interval inter = res.get(0);
            if (inter.start == Integer.MIN_VALUE) {
                res.remove(0);
            }
        }
        if (res.size() > 0) {
            Interval inter = res.get(res.size() - 1);
            if (inter.end == Integer.MAX_VALUE) {
                res.remove(res.size() - 1);
            }
        }
        return res;
    }
    
    private void getShared(List<Interval> ft0, List<Interval> ft1, List<Interval> res) {
        int i = 0, j = 0;
        while (i < ft0.size() && j < ft1.size()) {
            Interval t0 = ft0.get(i);
            Interval t1 = ft1.get(j);
            if (t0.start >= t1.end) {
                j++;
            } else if (t0.end <= t1.start) {
                i++;
            } else {
                Interval share = new Interval(Math.max(t0.start, t1.start), Math.min(t0.end, t1.end));
                res.add(share);
                if (t0.end - share.end > 1 ) {
                    t0.start = share.end;
                    j++;
                } else if (t1.end - share.end > 1 ) {
                    t1.start = share.end;
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
        }
    }
}
