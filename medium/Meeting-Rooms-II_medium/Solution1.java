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
        List<int[]> list = new ArrayList<int[]>();
        for(Interval inter : intervals) {
            list.add(new int[]{inter.start, 1});
            list.add(new int[]{inter.end, -1});
        }
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int cnt = 0, max = 0;
        for(int[] o1 : list) {
            cnt += o1[1];
            max = Math.max(cnt, max);
        }
        return max;
    }
}
