/*

Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

*/

class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int cnt = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'X') {
                    dfs(board, i, j);
                    cnt++;
                }
                
            }
        }
        return cnt;
    }
    
    private void dfs(char[][] board, int i, int j) {
        if(i<0 || i>= board.length || j<0 || j>=board[0].length || board[i][j] != 'X') return;
        board[i][j] = '#';
        dfs(board, i+1, j);
        dfs(board, i, j+1);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
    }
}
