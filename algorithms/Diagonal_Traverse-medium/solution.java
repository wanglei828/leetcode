/*

Given a matrix of M x N elements (M rows, N columns), 
return all elements of the matrix in diagonal order as shown in the below image.

 

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Note:

The total number of elements of the given matrix will not exceed 10,000.

*/

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[]{};
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = 0;
        int r = 0, c = 0;
        int[] ans = new int[m*n];
        while(cnt < m*n) {
            do{
                if(r>=0 && r<m && c>=0 && c<n) {
                    ans[cnt] = matrix[r][c];
                    cnt++;
                }
                r--;
                c++;
            }while(r>=0 && r<m && c>=0 && c<n);
            r++;
            do {
                if(r>=0 & r<m && c>=0 && c<n) {
                    ans[cnt] = matrix[r][c];
                    cnt++;
                }
                r++;
                c--;
            }while(r>=0 & r<m && c>=0 && c<n);
            c++;
        }
        return ans;
    }
}
