/*

On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. 
Each worker and bike is a 2D coordinate on this grid.

We assign one unique bike to each worker 
so that the sum of the Manhattan distances between each worker and their assigned bike is minimized.

The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.

*/

class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] used = new boolean[bikes.length];
        return help(workers, bikes, used, 0, 0);
    }
    
    private int help(int[][] workers, int[][] bikes, boolean[] used, int distance, int cur) {
        if(cur == workers.length) return distance;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<bikes.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            min = Math.min(min, help(workers, bikes, used, distance + Math.abs(workers[cur][0] - bikes[i][0]) + Math.abs(workers[cur][1] - bikes[i][1]), cur+1));
            used[i] = false;
        }
        return min;
    }
}
