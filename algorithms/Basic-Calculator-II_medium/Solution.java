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
    int index;
    public int calculate(String s) {
        index = 0;
        s = s.replaceAll("\\s", "");
        return parseExp(s);
    }
    
    private int parseExp(String s) {
        int lhs = parseFac(s);
        while (index < s.length() && (s.charAt(index) == '+' ||
                                     s.charAt(index) == '-')) {
            char op = s.charAt(index);
            index++;
            int rhs = parseFac(s);
            lhs = calc(op, lhs, rhs);
        }
        return lhs;
    }
    
    private int parseFac(String s) {
        int lhs = parseNum(s);
        while (index < s.length() && (s.charAt(index) == '*' ||
              s.charAt(index) == '/')) {
            char op = s.charAt(index);
            index++;
            int rhs = parseNum(s);
            lhs = calc(op, lhs, rhs);
        }
        return lhs;
    }
    
    private int parseNum(String s) {
        int num = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + s.charAt(index) - '0';
            index++;
        }
        return num;
    }
    
    private int calc(char op, int lhs, int rhs) {
        int res = 0;
        switch (op) {
            case '+': res = lhs + rhs; break;
            case '-': res = lhs - rhs; break;
            case '*': res = lhs * rhs; break;
            case '/': res = lhs / rhs; break;
        }
        return res;
    }
}
