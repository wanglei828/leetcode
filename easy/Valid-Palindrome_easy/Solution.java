/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        int j= s.length() -1;
        int i = 0;
        while(i<j) {
            while(!Character.isDigit(s.charAt(i)) && !Character.isAlphabetic(s.charAt(i)) && i<j) i++;
            while(!Character.isDigit(s.charAt(j)) && !Character.isAlphabetic(s.charAt(j)) && j>i) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
