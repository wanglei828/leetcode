/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        if(n<=0) return new int[0][0];
        int count = 1;
        int[][] res = new int[n][n];
        int r = 0;
        while(count<= n*n) {
            for(int i=r; i<n-r; i++) {
                res[r][i] = count;
                count++;
            }
            for(int i=r+1; i<n-r; i++) {
                res[i][n-1-r] = count;
                count++;
            }
            for(int i=n-2-r; i>=r; i--) {
                res[n-1-r][i] = count;
                count++;
            }
            for(int i=n-2-r; i>r; i--) {
                res[i][r] = count;
                count++;
            }
            r++;
        }
        return res;
    }
}
