/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
*/

public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        if(num == 2 || num == 3) return false;
        int h = 1;
        int t = num;
        while(h<=t) {
            int m = h + (t-h)/2;
            long prod = (long)m*(long)m;
            if(prod < num) {
                h = m+1;
            } else if(prod > num) {
                t = m-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
