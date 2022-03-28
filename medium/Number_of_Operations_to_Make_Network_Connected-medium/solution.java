/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network 
where connections[i] = [ai, bi] represents a connection between computers ai and bi. 
Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, 
and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
 

Constraints:

1 <= n <= 105
1 <= connections.length <= min(n * (n - 1) / 2, 105)
connections[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated connections.
No two computers are connected by more than one cable.
*/

class Solution {
    HashMap<Integer, List<Integer>> map;
    boolean[] visit;
    public int makeConnected(int n, int[][] connections) {
        visit = new boolean[n];
        map = new HashMap<Integer, List<Integer>>();
        if (connections.length < n-1) {
            return -1;
        }
        for(int[] cn : connections) {
            int p0 = cn[0];
            int p1 = cn[1];
            if (map.containsKey(p0)) {
                List<Integer> list = map.get(p0);
                list.add(p1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(p1);
                map.put(p0, list);
            }
            if (map.containsKey(p1)) {
                List<Integer> list = map.get(p1);
                list.add(p0);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(p0);
                map.put(p1, list);
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if (!visit[i]) {
                cnt++;
                dfs(i);
            }
        }
        return cnt-1;
    }
    
    private void dfs(int node) {
        visit[node] = true;
        if (map.containsKey(node)) {
            List<Integer> list = map.get(node);
            for (int i = 0; i < list.size(); i++) {
                int cur = list.get(i);
                if(visit[cur]) continue;
                dfs(cur);
            }
        }
    }
}
