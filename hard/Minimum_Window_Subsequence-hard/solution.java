/*

Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". 
If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:

Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
 

Note:

All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].

*/

class Solution {
    public String minWindow(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            if(S.charAt(i) == T.charAt(0)) {
                dp[i][0] = i;
            } else {
                if(i == 0) {
                    dp[0][0] = -1;
                } else {
                    dp[i][0] = dp[i-1][0];
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(j > i) {
                    dp[i][j] = -1;
                    continue;
                }
                if(S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        String ans = "";
        for(int i=0; i<m; i++) {
            if(dp[i][n-1] > -1) {
                if(min > (i-dp[i][n-1]+1)) {
                    min = i-dp[i][n-1]+1;
                    ans = S.substring(dp[i][n-1], i+1);
                }
            }
        }
        return ans;
    }
}
