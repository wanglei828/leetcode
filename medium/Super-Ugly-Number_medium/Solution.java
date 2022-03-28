/*
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is 
the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
*/

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] a = new int[n];
        int k = primes.length;
        int[] p = new int[k];
        a[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                while (primes[j] * a[p[j]] <= a[i - 1]) {
                    p[j]++;
                }
            }
            a[i] = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                a[i] = Math.min(a[i], primes[j] * a[p[j]]);
            }
        }
        return a[n - 1];
    }
}
