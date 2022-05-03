/*
Given a Tic-Tac-Toe board as a string array board, 
return true if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. The ' ' character represents an empty square.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares ' '.
The first player always places 'X' characters, while the second player always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.

Input: board = ["O  ","   ","   "]
Output: false
Explanation: The first player always plays "X".

Input: board = ["XOX"," X ","   "]
Output: false
Explanation: Players take turns making moves.

Input: board = ["XOX","O O","XOX"]
Output: true
 

Constraints:

board.length == 3
board[i].length == 3
board[i][j] is either 'X', 'O', or ' '.
*/

class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int anti = 0;
        int cx = 0;
        int co = 0;
        for (int i = 0; i < 3; i++) {
            String s = board[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == 'X') {
                    rows[i]++;
                    cols[j]++;
                    cx++;
                    if (i == j) {
                        diag++;
                    }
                    if (i + j == 2) {
                        anti++;
                    }
                } else if (c == 'O') {
                    rows[i]--;
                    cols[j]--;
                    co++;
                    if (i == j) {
                        diag--;
                    }
                    if (i + j == 2) {
                        anti--;
                    }
                }
            }
        }
        boolean xwin = false, owin = false;
        for (int i = 0; i < 3; i++) {
            if (rows[i] == 3) {
                xwin = true;
            } else if (rows[i] == -3) {
                owin = true;
            }
            if (cols[i] == 3) {
                xwin = true;
            } else if (cols[i] == -3) {
                owin = true;
            }
        }
        if (diag == 3) {
            xwin = true;
        } else if (diag == -3) {
            owin = true;
        }
        if (anti == 3) {
            xwin = true;
        } else if (anti == -3) {
            owin = true;
        }
        
        if (co > cx) return false;
        if (cx > co + 1) return false;
        if (xwin && co == cx) return false;
        if (owin && cx > co) return false;
        if (xwin && owin) return false;
        return true;
    }
}
