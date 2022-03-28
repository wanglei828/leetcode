/*

Given a non-empty string check if it can be constructed by taking a substring of it 
and appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length()/2;
        for(int i=1; i<=n; i++) {
            String sub = s.substring(0, i);
            if(check(sub, s)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean check(String sub, String s) {
        int ns = sub.length();
        int n = s.length();
        if(n%ns != 0) return false;
        int k = n/ns;
        for(int i=1; i<k; i++) {
            if(!sub.equals(s.substring(i*ns, (i+1)*ns))) {
                return false;
            }
        }
        return true;
    }
}
