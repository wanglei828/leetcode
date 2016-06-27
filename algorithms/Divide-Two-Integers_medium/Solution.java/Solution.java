/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;
        long pEnd = Math.abs((long)dividend);
        long pSor = Math.abs((long)divisor);
        int res = 0;
        int i = 0;
        while(pSor<<(i+1) <= pEnd) i++;
        while(pEnd >= pSor) {
            if(pEnd >= pSor<<i) {
                pEnd -= pSor<<i;
                res += 1<<i;
            }
            i--;
        }
        if(dividend > 0 && divisor > 0 || dividend <0 && divisor <0) {
            return res;
        } else {
            return 0-res;
        }

    }
}
