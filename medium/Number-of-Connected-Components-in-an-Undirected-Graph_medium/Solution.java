/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/

public class Solution {
    private int[] root;
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0 || edges[0].length == 0) return n;
        root = new int[n];
        for(int i=0; i<n; i++) {
            root[i] = i;
        }
        for(int i=0; i<edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<n; i++) {
            set.add(find(i));
        }
        return set.size();
    }
    
    private int find(int node) {
        while(root[node] != node) {
            int tmp = root[node];
            root[node] = root[tmp];
            node = tmp;
        }
        return node;
    }
    
    private void union(int n1, int n2) {
        root[find(n1)] = find(n2);
    }
}
