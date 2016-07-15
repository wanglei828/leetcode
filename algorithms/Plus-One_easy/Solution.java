/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)  return new int[0];
        int n = digits.length;
        int not9 = -1;
        for(int i=0; i<n; i++) {
            if(digits[i] != 9) {
                not9 = i;
            }
        }
        if(not9 == -1) {
            int[] res = new int[n+1];
            res[0] = 1;
            return res;
        } else {
            digits[not9++]++;
            while(not9<n) {
                digits[not9++] = 0;
            }
            return digits;
        }
    }
}
