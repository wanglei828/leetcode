/*

Find the length of the longest substring T of a given string (consists of lowercase letters only) 
such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

*/

class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        return help(s, 0, s.length()-1, k);
    }
    
    private int help(String s, int start, int end, int k) {
        if(end - start + 1 < k) return 0;
        int[] cnt = new int[26];
        for(int i=start; i<=end; i++) {
            char c = s.charAt(i);
            cnt[c-'a']++;
        }
        boolean split = false;
        int curStart = start;
        int ans = 0;
        for(int i=start; i<=end; i++) {
            char c = s.charAt(i);
            if(cnt[c-'a'] < k && cnt[c-'a']>0) {
                split = true;
                ans = Math.max(ans, help(s, curStart, i-1, k));
                curStart = i+1;
            }
        }
        if(!split) return end - start + 1;
        return Math.max(ans, help(s, curStart, end ,k));
    }
}
