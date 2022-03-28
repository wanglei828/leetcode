/*

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/

public class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] flag = new int[26];
        Arrays.fill(flag, -1);
        int n = s.length();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(flag[c-'a'] == -1) {
                flag[c-'a'] = i;
            } else{
                flag[c-'a'] = -2;
            }
        }
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(flag[c-'a'] != -2) {
                return flag[c-'a'];
            }
        }
        return -1;
    }
}
