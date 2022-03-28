/*
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    int start = (stack.isEmpty())? -1 : stack.peek();
                    max = Math.max(max, i-start);
                } else {
                    stack.clear();
                    stack.push(i);
                }
            }
        }
        return max;
    }
 }
