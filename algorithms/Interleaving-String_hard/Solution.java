/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if( s1 == null || s1.length() == 0) return ((s2 == null && s3 == null) || (s2 != null && s2.equals(s3)));
        if( s2 == null || s2.length() == 0) return ((s1 == null && s3 == null) || (s1 != null && s1.equals(s3)));
        if( s3 == null || s3.length() == 0) return ((s1 == null && s2 == null) || (s1.length() == 0 && s2.length() == 0) );
        if(s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length();
        int n = s2.length();
        boolean[][] res = new boolean[m+1][n+1];
        res[0][0] = true;
        for(int i=1; i<=m; i++) {
            res[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
        }
        for(int i=1; i<=n; i++) {
            res[0][i] = s2.substring(0,i).equals(s3.substring(0,i));
        }
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                res[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && res[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && res[i][j-1]);
            }
        }
        return res[m][n];
    }
}
