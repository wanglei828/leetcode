/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m*n;
        int r = 0;
        while(count != 0) {
            for(int i=r; i<n-r; i++) {
                res.add(matrix[r][i]);
                count--;
            }
            if(count == 0) break;
            for(int i=r+1; i<m-r; i++) {
                res.add(matrix[i][n-1-r]);
                count--;
            }
            if(count == 0) break;
            for(int i=n-2-r; i>=r; i--) {
                res.add(matrix[m-1-r][i]);
                count--;
            }
            if(count == 0) break;
            for(int i=m-2-r; i>=1+r; i--) {
                res.add(matrix[i][r]);
                count--;
            }
            r++;
        }
        return res;
    }
}
