/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
*/

public class Solution {
    private char[][] pair = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    private List<String> res = new ArrayList<String>();
    public List<String> findStrobogrammatic(int n) {
        if(n == 0) return res;
        dfs(new char[n], 0, n-1);
        return res;
    }
    
    private void dfs(char[] c, int h, int t) {
        if(h>t) {
            String str = new String(c);
            res.add(str);
            return;
        }
        for(char[] p: pair) {
            c[h] = p[0];
            c[t] = p[1];
            if(c.length > 1 && c[0] == '0') continue;
            if(h < t || h == t && p[0] == p[1]) {
                dfs(c, h+1, t-1);
            }
        }
    }
}
