/*
Given a string s, return the number of different non-empty palindromic subsequences in s. 
Since the answer may be very large, return it modulo 10^9 + 7.

A subsequence of a string is obtained by deleting zero or more characters from the string.

A sequence is palindromic if it is equal to the sequence reversed.

Two sequences a1, a2, ... and b1, b2, ... are different if there is some i for which ai != bi.

 

Example 1:

Input: s = "bccb"
Output: 6
Explanation: The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
Note that 'bcb' is counted only once, even though it occurs twice.
Example 2:

Input: s = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"
Output: 104860361
Explanation: There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
 

Constraints:

1 <= s.length <= 1000
s[i] is either 'a', 'b', 'c', or 'd
*/

class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int mod = 1000_000_000 + 7;
        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                } else {
                    dp[i][j] = dp[i+1][j-1] * 2;
                    int lo = i+1, hi = j-1;
                    while(lo < j && s.charAt(lo) != s.charAt(i)) {
                        lo++;
                    }
                    while(hi > i && s.charAt(hi) != s.charAt(j)) {
                        hi--;
                    }
                    if (lo == hi) {
                        dp[i][j] += 1;
                    } else if (lo < hi) {
                        dp[i][j] -= dp[lo+1][hi-1];
                    } else {
                        dp[i][j] += 2;
                    }
                }
                if (dp[i][j] < 0) {
                    dp[i][j] += mod;
                }
                dp[i][j] %= mod;
            }
        }
        return dp[0][n-1];
    }
}
