/*
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections 
forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. 
Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.
*/

class Solution {
    Map<Integer, Set<Integer>> graph;
    int[] visit;
    Set<Pair<Integer, Integer>> edges;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new HashMap<>();
        edges = new HashSet<Pair<Integer, Integer>>();
        formGraph(connections);
        visit = new int[n];
        Arrays.fill(visit, -1);
        dfs(0, 0, -1);
        List<List<Integer>> res = new ArrayList<>();
        for(Pair<Integer, Integer> p : edges) {
            List<Integer> list = new ArrayList<>();
            list.add(p.getKey());
            list.add(p.getValue());
            res.add(list);
        }
        return res;
    }
    
    private int dfs(int d, int rank, int prev) {
        if (visit[d] != -1) {
            return visit[d];
        }
        visit[d] = rank;
        int min = rank;
        for (int nd : graph.get(d)) {
            if (nd == prev) continue;
            int find = dfs(nd, rank + 1, d);
            if (find <= rank) {
                edges.remove(new Pair<Integer, Integer>(Math.min(d,nd), Math.max(d, nd)));
            }
            min = Math.min(min, find);
        }
        return min;
    }
    
    private void formGraph(List<List<Integer>> cons) {
        for (List<Integer> list : cons) {
            int u = list.get(0);
            int v = list.get(1);
            if (!graph.containsKey(u)) {
                graph.put(u, new HashSet<Integer>());
            }
            graph.get(u).add(v);
            if (!graph.containsKey(v)) {
                graph.put(v, new HashSet<Integer>());
            }
            graph.get(v).add(u);
            edges.add(new Pair<Integer, Integer>(Math.min(u,v), Math.max(u,v)));
        }
    }
}
