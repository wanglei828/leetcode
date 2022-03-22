/*
The diameter of a tree is the number of edges in the longest path in that tree.

There is an undirected tree of n nodes labeled from 0 to n - 1. 
You are given a 2D array edges where edges.length == n - 1 and edges[i] = [ai, bi] indicates that 
there is an undirected edge between nodes ai and bi in the tree.

Return the diameter of the tree.

Input: edges = [[0,1],[0,2]]
Output: 2
Explanation: The longest path of the tree is the path 1 - 0 - 2.

Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
Output: 4
Explanation: The longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
 

Constraints:

n == edges.length + 1
1 <= n <= 104
0 <= ai, bi < n
ai != bi
*/

class Solution {
    List<Set<Integer>> graph;
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            graph.add(set);
        }
        for (int[] edge : edges) {
            int p0 = edge[0];
            int p1 = edge[1];
            graph.get(p0).add(p1);
            graph.get(p1).add(p0);
        }
        Queue<Integer>  q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                q.add(i);
            }
        }
        int layer = 0;
        int left = n;
        while(left > 2) {
            left -= q.size();
            Queue<Integer> nq = new LinkedList<>();
            while(!q.isEmpty()) {
                int cur = q.poll();
                int neighbor = graph.get(cur).iterator().next();
                graph.get(neighbor).remove(cur);
                if(graph.get(neighbor).size() == 1) {
                    nq.add(neighbor);
                }
            }
            q = nq;
            layer++;
        }
        if (left == 1) {
            return layer * 2;
        } else {
            return layer *2 + 1;
        }
    }
    
}

