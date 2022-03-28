/*
Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, 
count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, 
the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.

Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.
*/

public class Solution {
    private int[][] jump;
    private int[] visit;
    public int numberOfPatterns(int m, int n) {
        jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[4][6] = jump[6][4] = 5;
        jump[7][9] = jump[9][7] = 8;
        jump[1][7] = jump[7][1] = 4;
        jump[2][8] = jump[8][2] = 5;
        jump[3][9] = jump[9][3] = 6;
        jump[1][9] = jump[9][1] = jump[7][3] = jump[3][7] = 5;
        visit = new int[10];
        int count = 0;
        count += dfs(1, 0, 0, m, n)*4;
        count += dfs(2, 0, 0, m, n)*4;
        count += dfs(5, 0, 0, m, n);
        return count;
    }
    
    private int dfs(int cur, int count, int len, int m, int n) {
        len++;
        if(len > n) return count;
        if(len >=m ) count++;
        visit[cur] = 1;
        for(int next = 1; next<=9; next++) {
            if(visit[next] == 0 && (jump[cur][next] == 0 || visit[jump[cur][next]] == 1)) {
                count = dfs(next, count, len, m, n);
            }
        }
        visit[cur] = 0;
        return count;
    }
}
