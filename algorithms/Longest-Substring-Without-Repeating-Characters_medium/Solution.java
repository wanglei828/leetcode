/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        int n = s.length();
        int start = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c)+1;
                map.put(c, i);
                max = Math.max(max, i-start+1);
            } else {
                map.put(c, i);
                max = Math.max(max, i-start+1);
            }
        }
        return max;
    }
}
