/*
Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].

 

Example 1:

Input: n = 3
Output: 3
Example 2:

Input: n = 11
Output: 0
Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 

Constraints:

1 <= n <= 231 - 1
*/

class Solution {
    public int findNthDigit(int n) {
        long level = 1;
        long base = 9;
        long t = n;
        long start = 0;
        t -= base * level;
        while (t > 0) {
            start += base;
            level++;
            base *= 10;
            t -= base * level;
        }
        t += base*level;
        if (t % level == 0) {
            long num = start + t / level;
            return (int)num % 10;
        } else {
            long num = start + t / level + 1;
            long cnt = level - t % level;
            while (cnt > 0) {
                num /= 10;
                cnt--;
            }
            return (int)num % 10;
        }       
    }
}
