/*
Given a string s, return the length of the longest repeating substrings. 
If no repeating substring exists, return 0.

 

Example 1:

Input: s = "abcd"
Output: 0
Explanation: There is no repeating substring.
Example 2:

Input: s = "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
Example 3:

Input: s = "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs 3 times.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase English letters.
*/

class Solution {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int h = 1, t = n;
        while (h <= t) {
            int m = h + (t-h) / 2;
            if (check(s, m, n)) {
                h = m + 1;
            } else {
                t = m - 1;
            }
        }
        return h - 1;
    }
    
    private boolean check(String s, int l, int n) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i + l <= n; i++) {
            String sub = s.substring(i, i+l);
            if (set.contains(sub)) {
                return true;
            } else {
                set.add(sub);
            }
        }
        return false;
    }
}
