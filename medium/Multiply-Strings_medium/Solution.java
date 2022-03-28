/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
*/

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        if(num1.equals("0") || num2.equals("0") ) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        if(n1 > n2) return multiply(num2, num1);
        int carry = 0;
        int i = n1-1;
        int shift = -1;
        String res = null;
        for(;i>=0;i--) {
            shift++;
            carry = 0;
            char c1 = num1.charAt(i);
            if(c1 == '0') continue;
            StringBuilder sb = new StringBuilder();
            for(int j=n2-1; j>=0; j--) {
                char c2 = num2.charAt(j);
                int prod = (c1-'0')*(c2-'0') + carry;
                int num = prod%10;
                carry = prod/10;
                sb.insert(0, num);
            }
            if(carry != 0) {
                sb.insert(0, carry);
            }
            for(int j=0; j<shift; j++) {
                sb.append(0);
            }
            if(res == null) {
                res = sb.toString();
            } else {
                res = add(res, sb.toString());
            }
        }
        return res;
    }
    
    private String add(String res, String prod) {
        StringBuilder sb = new StringBuilder();
        int i = res.length()-1;
        int j = prod.length()-1;
        int carry = 0;
        while(i>=0 && j>=0) {
            char c1 = res.charAt(i);
            char c2 = prod.charAt(j);
            int sum = c1-'0' + c2-'0' + carry;
            int num = sum%10;
            carry = sum/10;
            sb.insert(0, num);
            i--;
            j--;
        }
        while(j>=0) {
            char c = prod.charAt(j);
            int sum = c - '0' + carry;
            int num = sum%10;
            carry = sum/10;
            sb.insert(0, num);
            j--;
        }
        if(carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
