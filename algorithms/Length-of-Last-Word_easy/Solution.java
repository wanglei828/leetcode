/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        int i = s.length()-1;
        int j = -1;
        while(i>=0) {
            if(Character.isAlphabetic(s.charAt(i))) {
                j = i;
                i--;
                break;
            }
            i--;
        }
        if(j == -1) {
            return 0;
        }
        while(i>=0) {
             if(!Character.isAlphabetic(s.charAt(i))) {
                break;
            }
            i--;
        }
        return j - i;
    }
}
