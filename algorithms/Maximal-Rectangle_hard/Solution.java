/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n= matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if(j > 0) {
                        dp[i][j] = dp[i][j-1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        for(int j=0; j<n; j++) {
            Stack<Integer> s = new Stack<Integer>();
            s.push(-1);
            for(int i=0; i<m; i++) {
                while(s.peek() != -1 && dp[s.peek()][j] > dp[i][j]) {
                    int cur = s.pop();
                    max = Math.max(max, dp[cur][j]*(i-s.peek()-1));
                }
                s.push(i);
            }
            int last = s.peek();
            while(s.peek()!= -1) {
                int cur = s.pop();
                max = Math.max(max, dp[cur][j]*(last-s.peek()));
            }
        }
        return max;
    }
}
