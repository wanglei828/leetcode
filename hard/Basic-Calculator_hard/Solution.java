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
    int index = 0;
    public int calculate(String s) {
        String ns = s.replaceAll("\\s", "");
        return parseExp(ns);
    }
    
    private int parseExp(String s) {
        int lhs = parseNum(s);
        while (index < s.length() && (s.charAt(index) == '+' ||
                                     s.charAt(index) == '-')) {
            char op = s.charAt(index);
            index++;
            int rhs = parseNum(s);
            switch (op) {
                case '+': lhs += rhs; break;
                case '-': lhs -= rhs; break;
            }
        }
        return lhs;
    }
    
    private int parseNum(String s) {
        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            int rhs = parseExp(s);
            index++;
            return rhs;
        }
        int num = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + s.charAt(index) - '0';
            index++;
        }
        return num;
    }
}
