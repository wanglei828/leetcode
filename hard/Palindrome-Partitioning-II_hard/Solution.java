/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

*/

public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] c = s.toCharArray();
        int n = s.length();
        int[] res = new int[n];
        boolean[][] pal = new boolean[n][n];
        for(int i=0; i<n; i++) {
            int min = i;
            for(int j=0; j<=i; j++) {
                if(c[j] == c[i] && (j+1 > i-1 || pal[j+1][i-1])) {
                    pal[j][i] = true;
                    res[i] = (j == 0)? 0 : res[j-1]+1;
                    min = Math.min(min, res[i]);
                }
            }
            res[i] = min;
        }
        return res[n-1];
    }
}
