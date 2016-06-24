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
        String num = str.trim();
        if(num.equals("")) return 0;
        int sign = 1;
        int i = 0;
        if(num.charAt(0) == '-') {
            sign = -1;
            i = 1;
        } else if (num.charAt(0) == '+') {
            i = 1;
        }
        int result = 0;
        for(; i< num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                break;
            }
            if (result > 214748364) {
                if(sign==1) {
                    return 2147483647;
                }else {
                    return -2147483648;
                }

            } else if (result == 214748364) {
                if((num.charAt(i)-'0')>7 && sign==1) {
                    return 2147483647;
                } else if ((num.charAt(i)-'0')>8 && sign == -1){
                    return -2147483648;
                } else {
                    result = result*10 + num.charAt(i)-'0';
                }
            } else {
                result = result*10 + num.charAt(i)-'0';
            }
        }
        return result*sign;
    }
}
