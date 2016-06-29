/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<tokens.length; i++) {
            String str = tokens[i];
            if(!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                s.push(Integer.valueOf(str));
            } else {
                int n1 = s.pop();
                int n2 = s.pop();
                switch(str.charAt(0)) {
                    case '+': s.push(n2+n1); break;
                    case '-': s.push(n2-n1); break;
                    case '*': s.push(n2*n1); break;
                    case '/': s.push(n2/n1); break;
                }
            }
        }
        return s.pop();
    }
}
