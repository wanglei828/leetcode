/*

Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

 

Example 1:

Input: "())"
Output: 1
Example 2:

Input: "((("
Output: 3
Example 3:

Input: "()"
Output: 0
Example 4:

Input: "()))(("
Output: 4
 

Note:

S.length <= 1000
S only consists of '(' and ')' characters.

*/

class Solution {
    public int minAddToMakeValid(String S) {
        if(S == null | S == "") return 0;
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(c == '(') {
                st.push(c);
            } else {
                if(!st.isEmpty()) {
                    st.pop();
                } else {
                    count++;
                }
            }
        }
        return count + st.size();
    }
}
