/*

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] sp1 = new int[26];
        for(int i=0; i<s1.length(); i++) {
            char c = s1.charAt(i);
            sp1[c-'a']++;
        }
        for(int i=0; i<=s2.length()-s1.length(); i++) {
            int[] sp= new int[26];
            for(int j=i; j<i+s1.length(); j++) {
                char c = s2.charAt(j);
                sp[c-'a']++;
            }
            if(check(sp1, sp)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean check(int[] sp1, int[] sp2) {
        for(int i=0; i<26; i++) {
            if(sp1[i] != sp2[i]) {
                return false;
            }
        }
        return true;
    } 
}
