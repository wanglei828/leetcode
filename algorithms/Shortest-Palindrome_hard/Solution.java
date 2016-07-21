/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/

public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int h = 0;
        int t = s.length()-1;
        while(t>=0) {
            if(s.charAt(h) == s.charAt(t)) {
                h++;
            }
            t--;
        }
        if(h == s.length()) {
            return s;
        }
        String suffix = s.substring(h);
        String prefix = (new StringBuilder(suffix)).reverse().toString();
        String mid = shortestPalindrome(s.substring(0,h));
        return prefix + mid + suffix;
    }
}
