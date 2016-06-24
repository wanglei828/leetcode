/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
*/

public class Solution {
    public boolean isPowerOfFour(int num) {
        int c0 = 0;
        int c1 = 0;
        while(num>0) {
            if((num&1) == 1) {
                c1++;
            } else {
                c0++;
            }
            num >>=1;
        }
        return c1 == 1 && c0%2 == 0;
    }
}
