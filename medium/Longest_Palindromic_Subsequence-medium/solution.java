/*

Given a string s, find the longest palindromic subsequence's length in s. 
You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int n = s.length();
        int[][] dp = new int[n][n];
        return helper(s, 0, n-1, dp);
    }
    
    private int helper(String s, int i, int j, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        if(i == j) {
            dp[i][j] = 1;
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = helper(s, i+1, j-1, dp) + 2;
        } else {
            dp[i][j] = Math.max(helper(s, i+1, j, dp), helper(s, i, j-1, dp));
        }
        return dp[i][j];
    }
}
