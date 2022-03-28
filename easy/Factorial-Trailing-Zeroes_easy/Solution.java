/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        long x = 5;
        while(n>=x) {
            count += n/x;
            x = x*5;
        }
        return count;
    }
}
