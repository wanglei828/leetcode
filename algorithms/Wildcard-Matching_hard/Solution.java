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
        int i=0;
        int j=0;
        int sIndex = -1;
        int starIndex = -1;
        while(i < s.length()) {
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                sIndex = i;
                j++;
            } else if(starIndex != -1) {
                j = starIndex + 1;
                i = sIndex + 1;
                sIndex++;
            } else {
                break;
            }
        }
        if(i == s.length()) {
            while(j<p.length()) {
                if(p.charAt(j) != '*') {
                    return false;
                }
                j++;
            }
            return true;
        } else {
            return false;
        }
    }
}
