/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() <=1 ) return s;
        String res = s.substring(0,1);
        for(int i=1; i<s.length(); i++) {
            String left = uni(s, i);
            String right = both(s, i);
            if(res.length() < left.length()) {
                res = left;
            }
            if(res.length() < right.length()) {
                res = right;
            }
        }
        return res;
    }
    
    private String uni(String s, int i) {
        int h = i-1;
        int t = i+1;
        while(h>=0 && t<s.length() && s.charAt(h) == s.charAt(t)) {
            h--;
            t++;
        }
        return s.substring(h+1, t);
    }
    private String both(String s, int i) {
        int h = i-1;
        int t =i;
        while(h>=0 && t<s.length() && s.charAt(h) == s.charAt(t)) {
            h--;
            t++;
        }
        return s.substring(h+1, t);       
    }
}
