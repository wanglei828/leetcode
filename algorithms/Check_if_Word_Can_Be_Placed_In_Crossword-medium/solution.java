/*
You are given an m x n matrix board, representing the current state of a crossword puzzle. 
The crossword contains lowercase English letters (from solved words), ' ' to represent any empty cells, and '#' to represent any blocked cells.

A word can be placed horizontally (left to right or right to left) or vertically (top to bottom or bottom to top) in the board if:

It does not occupy a cell containing the character '#'.
The cell each letter is placed in must either be ' ' (empty) or match the letter already on the board.
There must not be any empty cells ' ' or other lowercase letters directly left or right of the word if the word was placed horizontally.
There must not be any empty cells ' ' or other lowercase letters directly above or below the word if the word was placed vertically.
Given a string word, return true if word can be placed in board, or false otherwise.
*/

class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public boolean placeWordInCrossword(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int x = i - dirs[k][0];
                    int y = j - dirs[k][1];
                    if (x >=0 && x < m && y >=0 && y < n && board[x][y] != '#') {
                        continue;
                    }
                    if (search(board, i, j, word, 0, k)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, int x, int y, String word, int index, int k) {
        if ((x < 0 || x >=m || y < 0 || y >= n) && index == word.length()) return true;
        if (x < 0 || x >=m || y < 0 || y >= n) return false;
        if (index == word.length()) {
            if (board[x][y] == '#') {
                return true;
            } else {
                return false;
            }
        }
        if (board[x][y] == word.charAt(index) || board[x][y] == ' ') {
            int nx = x + dirs[k][0];
            int ny = y + dirs[k][1];
            return search(board, nx, ny, word, index+1, k);
        } else {
            return false;
        }        
    }
}
