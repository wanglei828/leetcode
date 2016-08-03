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
        s = s.replaceAll(" ", "") + '#';
        char op = '+';
        int res = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                continue;
            } else {
                int cur = Integer.valueOf(s.substring(start,i));
                switch(op) {
                    case '+': 
                    case '-':
                        stack.push((op == '+')? cur : -cur);
                        break;
                    case '*':
                        stack.push(stack.pop()*cur);
                        break;
                    case '/':
                        stack.push(stack.pop()/cur);
                        break;
                }
            }
            op = c;
            start = i+1;
        }
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
   }
}
