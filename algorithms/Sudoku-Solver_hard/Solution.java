/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/

public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    
    private boolean helper(char[][] board, int i, int j) {
        if( i == 8 && j == 9) return true;
        if( i < 8 && j == 9) return helper(board, i+1, 0);
        if(board[i][j] != '.') return helper(board, i, j+1);
        for(int k=0; k<9; k++) {
            board[i][j] = (char)('1' + k);
            if(valid(board, i, j)) {
                if(helper(board, i, j+1)) {
                    return true;
                } 
            }
        }
        board[i][j] = '.';
        return false;
    }
    
    private boolean valid(char[][] board, int row, int col) {
        char c = board[row][col];
        for(int i=0; i<9; i++) {
            if(i != row && board[i][col] == c) {
                return false;
            }
        }
        for(int i=0; i<9; i++) {
            if(i != col && board[row][i] == c) {
                return false;
            }
        }
        int m = row/3;
        int n = col/3;
        m *=3;
        n *=3;
        for(int i=m; i<m+3; i++) {
            for(int j=n; j<n+3; j++) {
                if(i != row && j != col && board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
