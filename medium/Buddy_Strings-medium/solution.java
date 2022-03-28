/*
Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 

Example 1:

Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
Example 2:

Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
Example 3:

Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 

Constraints:

1 <= s.length, goal.length <= 2 * 104
s and goal consist of lowercase letters.
*/

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cnt[c - 'a']++;
                if (cnt[c - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int i = 0, j= 0;
            char sc = '*', gc = '*';
            boolean change = false;
            while(i < s.length() && j < goal.length()) {
                char c1 = s.charAt(i);
                char c2 = goal.charAt(j);
                if (c1 != c2) {
                    if (change) {
                        return false;
                    } else {
                        if (sc == '*') {
                            sc = c2;
                            gc = c1;
                        } else {
                            if (c1 == sc && c2 == gc) {
                                change = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
                i++;
                j++;
            }
            return change;
        }
    }
}
