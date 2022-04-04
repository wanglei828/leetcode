/*
You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:

Type-1: Remove the character at the start of the string s and append it to the end of the string.
Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
Return the minimum number of type-2 operations you need to perform such that s becomes alternating.

The string is called alternating if no two adjacent characters are equal.

For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
 

Example 1:

Input: s = "111000"
Output: 2
Explanation: Use the first operation two times to make s = "100011".
Then, use the second operation on the third and sixth elements to make s = "101010".
Example 2:

Input: s = "010"
Output: 0
Explanation: The string is already alternating.
Example 3:

Input: s = "1110"
Output: 1
Explanation: Use the second operation on the second element to make s = "1010".
 

Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.
*/

class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int even0 = 0;
        int even1 = 0;
        int odd0 = 0;
        int odd1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i % 2 == 0) {
                    even0++;
                } else {
                    odd0++;
                }
            } else {
                if (i % 2 == 0) {
                    even1++;
                } else {
                    odd1++;
                }
            }
        }
        int res = Math.min(even0 + odd1, even1 + odd0);
        s = s + s;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i-1) == '0') {
                even0--;
            } else {
                even1--;
            }
            int tmp = odd0;
            odd0 = even0;
            even0 = tmp;
            
            tmp = odd1;
            odd1 = even1;
            even1 = tmp;
            if ((n-1) % 2 == 1) {
                if (s.charAt(n+i-1) == '0') {
                    odd0++;
                } else {
                    odd1++;
                }
            } else {
                if (s.charAt(n+i-1) == '0') {
                    even0++;
                } else {
                    even1++;
                }
            }
            res = Math.min(res, even0 + odd1);
            res = Math.min(res, even1 + odd0);
        }
        return res;
    }
}
