/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, '+', '-', '*', '/' operators, and open '(' and closing parentheses ')'. 
The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1+1"
Output: 2
Example 2:

Input: s = "6-4/2"
Output: 4
Example 3:

Input: s = "2*(5+5*2)/3+(6/2+8)"
Output: 21
 

Constraints:

1 <= s <= 104
s consists of digits, '+', '-', '*', '/', '(', and ')'.
s is a valid expression.
*/

class Solution {
    int index;
    public int calculate(String s) {
        index = 0;
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
        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            int res = parseExp(s);
            index++;
            return res;
        }
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
            case '*': res = lhs * rhs; break;
            case '/': res = lhs / rhs; break;
            case '+': res = lhs + rhs; break;
            case '-': res = lhs - rhs; break;
        }
        return res;
    }
}
