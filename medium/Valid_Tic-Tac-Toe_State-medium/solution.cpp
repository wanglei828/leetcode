class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        int rows[3] = {0};
        int cols[3] = {0};
        int diag = 0;
        int anti = 0;
        int cx = 0, co = 0;
        for (int i = 0; i < board.size(); i++) {
            string & s = board[i];
            for (int j = 0; j < s.length(); j++) {
                if (s[j] == 'X') {
                    rows[i]++;
                    cols[j]++;
                    cx++;
                    if (i == j) {
                        diag++;
                    }
                    if (i + j == 2) {
                        anti++;
                    }
                }
                if (s[j] == 'O') {
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
        bool xwin = false, owin = false;
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
        if (xwin && cx == co) return false;
        if (owin && cx > co) return false;
        if (xwin && owin) return false;
        return true;
    }
};
