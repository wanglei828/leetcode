/*

A chess knight can move as indicated in the chess diagram below:

1 | 2 | 3
4 | 5 | 6
7 | 8 | 9
  | 0 | 

This time, we place our chess knight on any numbered key of a phone pad (indicated above), 
and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.

Each time it lands on a key (including the initial placement of the knight), 
it presses the number of that key, pressing N digits total.

How many distinct numbers can you dial in this manner?

Since the answer may be large, output the answer modulo 10^9 + 7.

 

Example 1:

Input: 1
Output: 10
Example 2:

Input: 2
Output: 20
Example 3:

Input: 3
Output: 46
 

Note:

1 <= N <= 5000

*/

class Solution {
    List<int[]> nums = new ArrayList<>();
    int cnt = 0;
    int[][] dp;
    int MOD = 1_000_000_007;
    public int knightDialer(int N) {
        nums.add(new int[]{4,6});
        nums.add(new int[]{6,8});
        nums.add(new int[]{7,9});
        nums.add(new int[]{4,8});
        nums.add(new int[]{3,9,0});
        nums.add(new int[]{});
        nums.add(new int[]{1,7,0});
        nums.add(new int[]{2,6});
        nums.add(new int[]{1,3});
        nums.add(new int[]{2,4});
        dp = new int[10][N];
        for(int i=0; i<=9; i++) {
            if(dp[i][N-1] == 0) {
                dp[i][N-1] = dfs(i, N-1);    
            }
            cnt = (cnt + dp[i][N-1])%MOD;
        }
        return cnt;
    }
    
    private int dfs(int cur, int N) {
        if(N == 0) {
            return 1;
        }
        if(dp[cur][N] != 0) {
            return dp[cur][N];
        }
        int[] next = nums.get(cur);
        for(int i=0; i<next.length; i++) {
            if(dp[next[i]][N-1] == 0) {
                dp[next[i]][N-1] = dfs(next[i], N-1);
            }
            dp[cur][N] = (dp[cur][N] + dp[next[i]][N-1])%MOD;
        }
        return dp[cur][N];
    }
}
