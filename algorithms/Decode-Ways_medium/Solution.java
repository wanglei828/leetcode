/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            char c = s.charAt(i-1);
            if (c == '0' ) {
                if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2') {
                    dp[i] = dp[i-2];
                } else {
                    return 0;
                }
   
            } else {
                if(s.charAt(i-2) == '0') {
                    dp[i] = dp[i-1];
                } else {
                    int tmp = Integer.valueOf(s.substring(i-2, i));
                    if(tmp <= 26) {
                        dp[i] = dp[i-1] + dp[i-2];
                    } else {
                        dp[i] = dp[i-1];
                    }
                }
            }
        }
        return dp[n];
    }
}
