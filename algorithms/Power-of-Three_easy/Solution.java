/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/

public class Solution {
    public boolean isPowerOfThree(int n) {
        if ( n < 0) return false;
        if (n == 1) return true;
        int i = n/3;
        int j = n%3;
        while (i > 0 && j == 0) {
            if (i == 1) return true;
            j = i%3;
            i = i/3;
        }
        return false;
    }
}
