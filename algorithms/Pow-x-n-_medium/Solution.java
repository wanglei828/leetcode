/*
Implement pow(x, n).
*/

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) {
            if(n > Integer.MIN_VALUE) {
                return 1/myPow(x, -n);
            } else {
                return 1/(myPow(x, Integer.MAX_VALUE)*x);
            }
        }
        double num = myPow(x, n/2);
        if(n%2 == 1) {
            return num*num*x;
        } else {
            return num*num;
        }
    }
}
