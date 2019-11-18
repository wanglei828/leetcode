/*

Given two non-negative integers num1 and num2 represented as string, 
return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for(int i=num1.length()-1, j=num2.length()-1; i>=0 || j>=0; i--, j--) {
            int sum = 0;
            if(i>=0) sum += num1.charAt(i) - '0';
            if(j>=0) sum += num2.charAt(j) - '0';
            sum += carry;
            carry = sum/10;
            res.append(sum%10);
        }
        if(carry == 1) {
            res.append('1');
        }
        return res.reverse().toString();
    }
}
