/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
*/

public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) return;
        reverse(s, 0, s.length-1);
        int start = 0;
        for(int i=0; i<s.length; i++) {
            if(s[i] == ' ' || i == s.length-1) {
                if(i != s.length-1) {
                    reverse(s, start, i-1);
                    start = i+1;
                } else {
                    reverse(s, start, i);
                }
            }
        }
    }
    
    private void reverse(char[] str, int s, int e) {
        if(str == null || str.length == 0 || s>=e) return;
        while(s<e) {
            char tmp = str[e];
            str[e] = str[s];
            str[s] = tmp;
            s++;
            e--;
        }
    }
}
