/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/

public class Solution {
    public int numSquares(int n) {
        if(n<=0) return 0;
        int maxS = (int)Math.sqrt(n);
        if(n == maxS*maxS) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = i;
            int sqrt = (int)Math.sqrt(i);
            for(int j=1; j<=sqrt; j++) {
                dp[i] = Math.min(dp[i], 1+ dp[i-j*j]);
            }
        }
        return dp[n];
    }
}
