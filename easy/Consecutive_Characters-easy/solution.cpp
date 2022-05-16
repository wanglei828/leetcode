/*
The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.
*/

class Solution {
public:
    int maxPower(string s) {
        char pre = '*';
        int cnt = 0;
        int res = 0;
        for (char c : s) {
            if (pre == '*' || pre != c) {
                cnt = 1;
            } else {
                cnt++;
            }
            pre = c;
            res = max(res, cnt);
        }
        return res;
    }
};
