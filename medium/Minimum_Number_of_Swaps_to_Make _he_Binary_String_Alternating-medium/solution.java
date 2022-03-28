/*
Given a binary string s, return the minimum number of character swaps to make it alternating, or -1 if it is impossible.

The string is called alternating if no two adjacent characters are equal. 
For example, the strings "010" and "1010" are alternating, while the string "0100" is not.

Any two characters may be swapped, even if they are not adjacent.

 

Example 1:

Input: s = "111000"
Output: 1
Explanation: Swap positions 1 and 4: "111000" -> "101010"
The string is now alternating.
Example 2:

Input: s = "010"
Output: 0
Explanation: The string is already alternating, no swaps are needed.
Example 3:

Input: s = "1110"
Output: -1
 

Constraints:

1 <= s.length <= 1000
s[i] is either '0' or '1'.
*/

class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        int c0 = 0, c1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                c0++;
            } else {
                c1++;
            }
        }
        if (Math.abs(c0 - c1) > 1) return -1;
        int res = 0;
        char base = ' ';
        if (c0 > c1 || c0 < c1) {
            base = (c0 > c1) ? '0' : '1';
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (s.charAt(i) != base) {
                        res++;
                    }
                } else {
                    if (s.charAt(i) == base) {
                        res++;
                    }
                }
            }
        } else {
            int res0 = 0;
            base = '0';
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (s.charAt(i) != base) {
                        res0++;
                    }
                } else {
                    if (s.charAt(i) == base) {
                        res0++;
                    }
                }
            }
            int res1 = 0;
            base = '1';
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (s.charAt(i) != base) {
                        res1++;
                    }
                } else {
                    if (s.charAt(i) == base) {
                        res1++;
                    }
                }
            }
            res = Math.min(res0, res1);
        }
        return res / 2;
    }
}
