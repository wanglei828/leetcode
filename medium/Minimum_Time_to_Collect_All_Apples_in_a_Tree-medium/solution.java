/*
Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. 
You spend 1 second to walk over one edge of the tree. 
Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, 
where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. 
Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], 
hasApple = [false,false,true,false,true,true,false]
Output: 8 

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
Output: 6

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
Output: 0
 

Constraints:

1 <= n <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai < bi <= n - 1
fromi < toi
hasApple.length == n
*/

class Solution {
    boolean[] visit;
    HashMap<Integer, List<Integer>> graph;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        visit = new boolean[n];
        graph = new HashMap<>();
        for (int[] edge: edges) {
            if (graph.containsKey(edge[0])) {
                graph.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                graph.put(edge[0], list);
            }
            if (graph.containsKey(edge[1])) {
                graph.get(edge[1]).add(edge[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                graph.put(edge[1], list);
            }
        }
        int step = dfs(0, hasApple);
        return (step > 0) ? step - 2 : step;
    }
    
    private int dfs(int node, List<Boolean> hasApple) {
        int step = 0;
        visit[node] = true;
        if (graph.containsKey(node)) {
            List<Integer> neighbors = graph.get(node);
            for (int neighbor : neighbors) {
                if (visit[neighbor]) continue;
                step += dfs(neighbor, hasApple);
            }
        }
        if (step > 0) {
            return step + 2;
        } else if (hasApple.get(node)) {
            return 2;
        } else {
            return 0;
        }
    }
}

