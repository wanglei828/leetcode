/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean find = false;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                find = helper(board, word, i, j, 0);
                if(find) {
                    return find;
                } 
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int i, int j, int k) {
        if(k == word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return false;
        
        if(board[i][j] == word.charAt(k)) {
            board[i][j] = '0';
            if(helper(board, word, i, j+1, k+1) || helper(board, word, i, j-1, k+1) || helper(board, word, i+1, j, k+1) || helper(board, word, i-1, j, k+1)) {
                return true;
            } else {
                board[i][j] = word.charAt(k);
                return false;
            }
        } else {
            return false;
        }
    }
}
