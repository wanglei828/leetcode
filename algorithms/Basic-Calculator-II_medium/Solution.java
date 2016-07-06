/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces. 
The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
*/

public class Solution {
	public int calculate(String s) {
	    if(s == null || s.length() == 0) return 0;
		String in = s.replaceAll("\\s", "") + " ";
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        int n = in.length();
        int start = 0;
        for(int i=0; i<n; i++) {
            char c = in.charAt(i);
            if(!Character.isDigit(c)) {
                int num = Integer.valueOf(in.substring(start, i));
                if(stack.isEmpty() || sign == '+' || sign == '-') {
                   if(sign == '+') {
                       stack.push(num);
                   } else {
                       stack.push(0-num);
                   }
                } else {
                    int num1 = stack.pop();
                    if(sign == '*') {
                        stack.push(num*num1);
                    } else if (sign == '/') {
                        stack.push(num1/num);
                    }
                }
                sign = c;
                start = i+1;
            }
        }
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
	}
}
