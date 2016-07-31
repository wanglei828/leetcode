/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null && p == null) return true;
        if(s == null || p == null) return false;
        if(p.length() == 0) return s.length() == 0;
        if(s.length() == 0) {
            int j = 0;
            while(j<p.length()) {
                if(p.charAt(j) != '*') {
                    if(j<p.length()-1 && p.charAt(j+1) == '*') {
                        j++;
                    } else {
                        return false;
                    }
                }
                j++;
            }
            return true;
        }
        if(p.length() == 1 || p.charAt(1) != '*') {
            return  (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        } else {
            return isMatch(s, p.substring(2)) || (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p);
        }
    }
}
