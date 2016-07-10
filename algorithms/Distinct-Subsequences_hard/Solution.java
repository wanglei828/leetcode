/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters 
without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

public class Solution {
    public int numDistinct(String s, String t) {
        if(t == null || t.length() == 0) return 1;
        if(s == null || s.length() == 0) return 0;
        int m = s.length();
        int n = t.length();
        int[][] res = new int[m+1][n+1];
        for(int i=0; i<=m; i++) {
            res[i][0] = 1;
        }
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    res[i][j] = res[i-1][j] + res[i-1][j-1];
                } else {
                    res[i][j] = res[i-1][j];
                }
            }
        }
        return res[m][n];
    }
}
