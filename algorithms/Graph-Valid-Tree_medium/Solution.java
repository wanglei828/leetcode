/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: 
“a tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 1) return true;
        if(edges == null || edges.length == 0 ) return false;
        int[] roots = new int[n];
        for(int i=0; i<n; i++) {
            roots[i] = i;
        }
        for(int[] e: edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if(root1 != root2) {
                roots[root1] = root2; //union
            } else {
                return false;
            }
        }
        return edges.length == n-1;
    }
    
    private int find(int[] roots, int i) {
        while(roots[i] != i) {
            int id = roots[i];
            roots[i] = roots[id];
            i = id;
        }
        return i;
    }
    
}
