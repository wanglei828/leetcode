/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)  return new int[0];
        int n = digits.length;
        int carry = 0;
        List<Integer> res = new ArrayList<Integer>();
        for(int i=n-1; i>=0; i--) {
            int sum = (i == n-1)? carry + digits[i] + 1 : carry + digits[i];
            res.add(0, sum%10);
            carry = sum/10;
        }
        if(carry != 0) {
            res.add(0, carry);
        }
        int[] rslt = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            rslt[i] = res.get(i);
        }
        return rslt;
    }
}
