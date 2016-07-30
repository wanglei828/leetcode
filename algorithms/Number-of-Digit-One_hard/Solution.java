/*
Given an integer n, count the total number of digit 1 appearing 
in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

*/

public class Solution {
    public int countDigitOne(int n) {
        int cnt = 0;
        int base = 1;
        int org = n;
        while(n>0) {
            int t = n%10;
            n /= 10;
            if(t>1) {
                cnt += (n+1)*base;
            } else if(t == 1) {
                cnt += n*base + 1 + org%base;
            } else {
                cnt += n*base;
            }
            base *= 10;
        }
        return cnt;
    }
}
