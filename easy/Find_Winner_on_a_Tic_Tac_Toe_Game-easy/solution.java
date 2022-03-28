/*
Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. 
return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: B wins.

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
*/

class Solution {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int dia = 0;
        int antiDia = 0;
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            if (i % 2 == 0) {
                rows[x]++;
                cols[y]++;
                if (x == y) {
                    dia++;
                }
                if (x + y == 2) {
                    antiDia++;
                } 
            } else {
                rows[x]--;
                cols[y]--;
                if (x == y) {
                    dia--;
                }
                if (x + y == 2) {
                    antiDia--;
                }                
            }
        }
        if (dia == 3 || antiDia == 3) {
            return "A";
        }
        if (dia == -3 || antiDia == -3) {
            return "B";
        }
        for (int i = 0; i < 3; i++) {
            if (rows[i] == 3 || cols[i] == 3) {
                return "A";
            }
            if (rows[i] == -3 || cols[i] == -3) {
                return "B";
            }
        }
        return (moves.length == 9)? "Draw" : "Pending";
    }
}
