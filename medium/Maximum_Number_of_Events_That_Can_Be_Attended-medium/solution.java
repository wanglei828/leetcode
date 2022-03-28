/*
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.
 
Example 1:
Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
  
Example 2:
Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
  
Constraints:

1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105
*/

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int lastDay = 0;
        for (int[] event : events) {
            lastDay = Math.max(lastDay, event[1]);
        }
        int res = 0;
        int index = 0;
        for (int day = 0; day <= lastDay; day++) {
            while(index < events.length) {
                if (day == events[index][0]) {
                    q.add(events[index]);
                    index++;
                } else {
                    break;
                }
            }
            if (!q.isEmpty()) {
                q.remove();
                res++;
            }
            while(!q.isEmpty()) {
                if (q.peek()[1] <= day) {
                    q.remove();
                } else {
                    break;
                }
            }        
        }
        return res;      
    }
}
