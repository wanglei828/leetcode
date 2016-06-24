/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/

public class Solution {
    public int countPrimes(int n) {
        if(n== 0 || n==1) return 0;
        int sum = 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for(int i = 2; i*i < n; i++) {
            if(!primes[i]) {
                continue;
            }
            for(int j=i*i; j < n; j+=i) {
                primes[j] = false;
            }
        }
        for(int i=2; i<n; i++) {
            if(primes[i]) {
               sum++; 
            }
        }
        return sum;
    }
}
