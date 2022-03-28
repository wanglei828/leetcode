/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. 
If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.
*/

public class Solution {
    public int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.equals("")) return 0;
        int sign = 1;
        int i = 0;
        if(str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        long result = 0;
        boolean hasDigit = false;
        for(;i<str.length(); i++) {
            char c = str.charAt(i);
            if(c>='0' && c<='9') {
                hasDigit = true;
                result = result*10 + str.charAt(i) -'0';
            } else {
                if(hasDigit) {
                    break;
                } else {
                    return 0;
                }
            }
            if(result > Integer.MAX_VALUE) {
                return (sign == 1)? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }            
        }
        return (int)result*sign;
    }
}
