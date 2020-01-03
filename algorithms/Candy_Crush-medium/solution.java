/*

This question is about implementing a basic elimination algorithm for Candy Crush.

Given a 2D integer array board representing the grid of candy, 
different positive integers board[i][j] represent different types of candies. 
A value of board[i][j] = 0 represents that the cell at position (i, j) is empty. 
The given board represents the state of the game following the player's move. 
Now, you need to restore the board to a stable state by crushing candies according to the following rules:

If three or more candies of the same type are adjacent vertically or horizontally, 
"crush" them all at the same time - these positions become empty.
After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, 
then these candies will drop until they hit a candy or bottom at the same time. 
(No new candies will drop outside the top boundary.)
After the above steps, there may exist more candies that can be crushed. 
If so, you need to repeat the above steps.
If there does not exist more candies that can be crushed (ie. the board is stable), 
then return the current board.
You need to perform the above rules until the board becomes stable, then return the current board.

Note:

The length of board will be in the range [3, 50].
The length of board[i] will be in the range [3, 50].
Each board[i][j] will initially start as an integer in the range [1, 2000].

*/

class Solution {
    public int[][] candyCrush(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        boolean todo = false;
        for(int i=0; i<r; i++) {
            for(int j=0; j+2<c; j++) {
                int v = Math.abs(board[i][j]);
                if(v != 0 && v == Math.abs(board[i][j+1]) && v == Math.abs(board[i][j+2])) {
                    todo = true;
                    board[i][j] = -v;
                    board[i][j+1] = -v;
                    board[i][j+2] = -v;
                }
            }
        }
        for(int i=0; i+2<r; i++) {
            for(int j=0; j<c; j++) {
                int v = Math.abs(board[i][j]);
                if(v != 0 && v == Math.abs(board[i+1][j]) && v == Math.abs(board[i+2][j])) {
                    todo = true;
                    board[i][j] = -v;
                    board[i+1][j] = -v;
                    board[i+2][j] = -v;
                }
            }
        }
        for(int i=0; i<c; i++) {
            int cur = r-1;
            for(int j=r-1; j>=0; j--) {
                if(board[j][i]>0) {
                    board[cur][i] = board[j][i];
                    cur--;
                }
            }
            while(cur>=0) {
                board[cur][i] = 0;
                cur--;
            }
        }
        return todo? candyCrush(board): board;
    }
}
