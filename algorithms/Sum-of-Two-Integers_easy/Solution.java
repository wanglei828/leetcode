/*
Calculate the sum of two integers a and b, 
but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/

public class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        while(a!= 0) {
            carry = a & b;
            b = a^b;
            a = carry<<1;
        }
        return b;
    }
}
