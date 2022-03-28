/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        if(rows != 9) return false;
        int cols = board[0].length;
        if(cols != 9) return false;
        Set<Character> rset = new HashSet<Character>();
        Set<Character> cset = new HashSet<Character>();
        for(int i = 0; i < 9; i++) {
            rset.clear();
            cset.clear();
            for(int j = 0; j < 9; j++){
                char tmp = board[i][j];
                if(board[i][j] != '.'){
                    if(!rset.add(board[i][j])) {
                        return false;
                    }
                }
                tmp = board[j][i];
                if(board[j][i] != '.') {
                    if(!cset.add(board[j][i])) {
                        return false;
                    }
                }
            }
        }// check column and row;
        for(int m=0; m<9; m+=3) {
            for(int n=0; n<9; n+=3) {
                rset.clear();
                for(int i=m; i<m+3; i++) {
                    for(int j=n; j<n+3; j++) {
                        if(board[i][j] != '.') {
                            if(!rset.add(board[i][j])) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
