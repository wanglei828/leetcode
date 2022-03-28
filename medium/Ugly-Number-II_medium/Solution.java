/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. 
Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. 
Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
*/

public class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int[] fac = {2, 3, 5};
        int[] index = new int[3];
        for(int i=1; i<n; i++) {
            for(int j=0; j<3; j++) {
                while(fac[j] * res[index[j]] <= res[i-1]) {
                    index[j]++;
                }
            }
            int min = Integer.MAX_VALUE;
            for(int j=0; j<3; j++) {
                min = Math.min(min, fac[j]*res[index[j]]);
            }
            res[i] = min;
        }
        return res[n-1];
    }
}
