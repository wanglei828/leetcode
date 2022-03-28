/*
Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.

 

Example 1:

Input: s = "(()))"
Output: 1
Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. 
We need to to add one more ')' at the end of the string to be "(())))" which is balanced.
Example 2:

Input: s = "())"
Output: 0
Explanation: The string is already balanced.
Example 3:

Input: s = "))())("
Output: 3
Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
 

Constraints:

1 <= s.length <= 105
s consists of '(' and ')' only.

*/

class Solution {
    public int minInsertions(String s) {
        int cnt = 0;
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                if (i < n-1) {
                    char c2 = s.charAt(i+1);
                    if (c2 == ')') {
                        if (st.isEmpty()) {
                            cnt += 1;
                            i++;
                        } else {
                            st.pop();
                            i++;
                        }
                    } else {
                        if (st.isEmpty()) {
                            cnt += 2;
                        } else {
                            cnt += 1;
                        }
                    }
                } else {
                    if (st.isEmpty()) {
                        cnt += 2;
                    } else {
                        st.pop();
                        cnt++;
                    }
                }
            }
        }
        if (!st.isEmpty()) {
            cnt += st.size()*2;
        }
        return cnt;
    }
}
