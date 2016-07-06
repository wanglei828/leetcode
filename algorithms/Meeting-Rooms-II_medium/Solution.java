/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0; i<n; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int max = 0;
        int i = 0;
        int j = 0;
        while(i<n && j<n) {
            if(start[i] < end[j]) {
                count++;
                max = Math.max(max, count);
                i++;
            } else if(start[i] > end[j]) {
                count--;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return max;
    }
}
