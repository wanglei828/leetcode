/*

On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. 
Each worker and bike is a 2D coordinate on this grid.

Our goal is to assign a bike to each worker. Among the available bikes and workers, 
we choose the (worker, bike) pair with the shortest Manhattan distance between each other, 
and assign the bike to that worker. 
(If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, 
we choose the pair with the smallest worker index; if there are multiple ways to do that, 
we choose the pair with the smallest bike index). We repeat this process until there are no available workers.

The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.

Example 1:
Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
Output: [1,0]
Explanation: 
Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].

Example 2:
Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
Output: [0,2,1]
Explanation: 
Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, 
thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].

Note:

0 <= workers[i][j], bikes[i][j] < 1000
All worker and bike locations are distinct.
1 <= workers.length <= bikes.length <= 1000
*/

class Solution {
    class Assign {
        int bike;
        int worker;
        int distance;
        public Assign(int b, int w, int d) {
            bike = b;
            worker = w;
            distance = d;
        }
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] res = new int[workers.length];
        boolean[] aworker = new boolean[workers.length];
        boolean[] abike = new boolean[bikes.length];
        PriorityQueue<Assign> q = new PriorityQueue<>((Assign a1, Assign a2)->{
            if(a1.distance == a2.distance) {
                if(a1.worker == a2.worker) return a1.bike - a2.bike;
                return a1.worker - a2.worker;
            } else {
                return a1.distance - a2.distance;
            }
        });
        for(int i=0; i<workers.length; i++) {
            for(int j=0; j<bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                q.add(new Assign(j, i, distance));
            }
        }
        int cnt = workers.length;
        while(!q.isEmpty() && cnt > 0) {
            Assign cur = q.poll();
            if(aworker[cur.worker] || abike[cur.bike]) continue;
            cnt--;
            aworker[cur.worker] = true;
            abike[cur.bike] = true;
            res[cur.worker] = cur.bike;
        }
        return res;
    }
}
