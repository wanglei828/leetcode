/*

You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 
 

Constraints:

trips.length <= 1000
trips[i].length == 3
1 <= trips[i][0] <= 100
0 <= trips[i][1] < trips[i][2] <= 1000
1 <= capacity <= 100000
*/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips == null || trips.length == 0) return true;
        int n = trips.length;
        int[][] start = new int[n][2];
        int[][] end = new int[n][2];
        for(int i=0; i<n; i++) {
            start[i][0] = trips[i][0];
            start[i][1] = trips[i][1];
            end[i][0] = trips[i][0];
            end[i][1] = trips[i][2];
        }
        Comparator com =  new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        };            
        Arrays.sort(start, com);
        Arrays.sort(end, com);
        int cur = 0, max = 0;
        int i=0, j=0;
        while(i<n && j<n) {
            if(start[i][1] < end[j][1]) {
                cur += start[i][0];
                i++;
            } else if (start[i][1] > end[j][1]) {
                cur -= end[j][0];
                j++;
            } else {
                cur = cur - end[j][0] + start[i][0];
                i++;
                j++;
            }
            max = Math.max(cur, max);
            if(max > capacity) {
                return false;
            }
        }
        return true;
    }
}
