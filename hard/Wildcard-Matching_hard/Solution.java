/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null && p == null) return true;
        if(s == null || p == null) return false;
        int lns = s.length(), lnp = p.length();
        int i=0, j=0;
        int jstar = -1;
        int istar = -1;
        while(i<lns) {
            if(j<lnp && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if(j<lnp && p.charAt(j) == '*') {
                jstar = j;
                istar = i;
                j++;
            } else if(jstar != -1) {
                j = jstar + 1;
                i = istar + 1;
                istar++;
            } else {
                break;
            }
        }
        if(i == lns) {
            while(j<lnp && p.charAt(j) == '*') j++;
            return j == lnp;
        } else {
            return false;
        }
    }
}
