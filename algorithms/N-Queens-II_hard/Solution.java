/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if(n==1) return 1;
        if(n<=0 || n == 2 || n == 3) return 0;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board, 0, n);
        return count;        
    }
    
    private void helper(char[][] board, int row, int n) {
        if(row == n) {
            count++;
            return;
        }
        for(int i=0; i<n; i++) {
            board[row][i] = 'Q';
            if(isValid(board, row, i)) {
                helper(board, row+1, n);
            }
            board[row][i] = '.';
        }
    }
    
    private boolean isValid(char[][] board, int row, int col) {
        for(int i=0; i<row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        int i = row-1;
        int j = col-1;
        while(i>=0 && j>=0) {
            if(board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row-1;
        j = col+1;
        while(i>=0 && j<board[0].length) {
            if(board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
