/*
mplement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
*/

public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        String str = (Character.isDigit(s.charAt(s.length()-1)))? s + " ": s;
        int res = 0;
        int sign = 1;
        int cur = 0;
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
                cur = cur*10 + c - '0';
            } else {
                if(c == '(') {
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                } else if(c == '+') {
                    res += sign*cur;
                    cur = 0;
                    sign = 1;
                } else if(c == '-') {
                    res += sign*cur;
                    cur = 0;
                    sign = -1;
                } else if(c == ')') {
                    res += sign*cur;
                    res *= stack.pop();
                    res += stack.pop();
                    cur = 0;
                } else {
                    res += sign*cur;
                    cur = 0;
                    sign = 1;
                }
            }
        }
        return res; 
    }
}
