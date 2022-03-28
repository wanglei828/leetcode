/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '{' || a == '[') {
                stack.push(s.charAt(i));
            } else {
                if(stack.empty()){
                    return false;
                }
                switch(a) {
                    case ')':
                        if(stack.pop() != '(') {
                            return false;
                        } break;
                    case '}':
                        if(stack.pop() != '{') {
                            return false;
                        } break;
                    case ']':
                        if(stack.pop() != '[') {
                            return false;
                        } break;
                    default: return false;
                }
            }
        }
        return stack.empty();
    }
}
