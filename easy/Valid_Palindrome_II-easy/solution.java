/*

Given a non-empty string s, you may delete at most one character. 
Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. 
The maximum length of the string is 50000.

*/

class Solution {
    public boolean validPalindrome(String s) {
        int h = 0, t = s.length()-1;
        while(h <= t) {
            if(s.charAt(h) == s.charAt(t)) {
                h++;
                t--;
            } else {
                return (isPalindrome(s, h+1, t) || isPalindrome(s, h, t-1));
            }
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
