/*

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), 
where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. 
How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2
 

Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.

*/

// Using Dijkstra's algorithm

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge: times) {
            int src = edge[0];
            int dst = edge[1];
            int weight = edge[2];
            if(!graph.containsKey(src)) {
                graph.put(src, new ArrayList<int[]>());
            }
            graph.get(src).add(new int[]{dst, weight});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((int[] o1, int[] o2)->{return o1[0] - o2[0];});
        q.offer(new int[]{0, K});
        Map<Integer, Integer> dist = new HashMap<>();
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int id = node[1];
            int weight = node[0];
            if(dist.containsKey(id)) continue;
            dist.put(id, weight);
            if(graph.containsKey(id)) {
                for(int[] edge: graph.get(id)) {
                    q.add(new int[]{weight+edge[1], edge[0]});
                }
            }
        }
        if(dist.size() !=N) return -1;
        int max = 0;
        for(int key: dist.keySet()) {
            max = Math.max(max, dist.get(key));
        }
        return max;
    }
}
