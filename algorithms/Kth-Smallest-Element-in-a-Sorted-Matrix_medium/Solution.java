/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = matrix.length;
        q.add(new int[]{matrix[0][0], 0, 0});
        int[] peek = new int[3];
        while(k>0) {
            peek = q.poll();
            if(peek[1] == 0 && peek[2] < n-1) {
                q.add(new int[]{matrix[peek[1]][peek[2]+1], peek[1], peek[2]+1});
            }
            if(peek[1] < n-1) {
                q.add(new int[]{matrix[peek[1]+1][peek[2]], peek[1]+1, peek[2]});
            }
            k--;
        }
        return peek[0];
    }
}
