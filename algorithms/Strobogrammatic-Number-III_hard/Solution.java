/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

For example,
Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are represented as string.
*/

public class Solution {
    private char[][] pair = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    private int cnt = 0;
    public int strobogrammaticInRange(String low, String high) {
        if(low == null || low.length() == 0 || high == null || high.length() == 0) return 0;
        int h = low.length(), t = high.length();
        for(int i=h; i<=t; i++) {
            dfs(low, high, 0, i-1, new char[i], i);
        }
        return cnt;
    }
    
    private void dfs(String low, String high, int h, int t, char[] c, int len) {
        if(h > t) {
            String str = new String(c);
            if(len == low.length() && str.compareTo(low) < 0 || len == high.length() && str.compareTo(high) >0) {
                return;
            } else {
                cnt++;
                return;
            }
        }
        for(char[] p:pair) {
            c[h] = p[0];
            c[t] = p[1];
            if(c.length > 1 && c[0] == '0') continue;
            if(h < t || h==t && p[0] == p[1]) dfs(low, high, h+1, t-1, c, len);
        }
    }
}
