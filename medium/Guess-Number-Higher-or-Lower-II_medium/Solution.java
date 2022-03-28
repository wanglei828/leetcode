/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. 
You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
*/


//win[i][j] = Min(k + Max(win[i][k-1], win[k+1][j]))
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] win = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                win[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int gap = 0; gap<=n-1; gap++) {
            for(int i=1; i<=n && i+gap<=n; i++) {
                int j = i+gap;
                if(i == j) {
                    win[i][j] = 0;
                } else if(i+1 == j) {
                    win[i][j] = i;
                } else {
                    for(int k=i+1; k<j; k++) {
                        win[i][j] = Math.min(win[i][j], k+Math.max(win[i][k-1], win[k+1][j]));
                    }
                }
            }
        }
        return win[1][n];
    }
}
