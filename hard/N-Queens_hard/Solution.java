/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        if(n==1) {
            List<String> list = new ArrayList<String>();
            list.add("Q");
            res.add(list);
            return res;
        }
        if(n<=0 || n == 2 || n == 3) return res;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board, 0, n);
        return res;
    }
    
    private void helper(char[][] board, int row, int n) {
        if(row == n) {
            List<String> list = new ArrayList<String>();
            for(int i=0; i<n; i++) {
                String tmp = new String(board[i]);
                list.add(tmp);
            }
            res.add(list);
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
