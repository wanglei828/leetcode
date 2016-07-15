/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. 
Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?
*/

import java.math.BigInteger;
public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length()<3) return false;
        int n = num.length();
        for(int i=1; i<=n/2; i++) {
            for(int j=1; Math.max(i, j) <= n-i-j; j++) {
                if(valid(i, j, num)) return true;
            }
        }
        return false;
    }
    
    private boolean valid(int i, int j, String num) {
        if(num.charAt(0) == '0' && i>1) return false;
        if(num.charAt(i) == '0' && j>1) return false;
        BigInteger b1 = new BigInteger(num.substring(0, i));
        BigInteger b2 = new BigInteger(num.substring(i, i+j));
        BigInteger sum = b1.add(b2);
        String sumstr = sum.toString();
        int start = i+j;
        while(start != num.length() && num.startsWith(sumstr, start)) {
            b1 = b2;
            b2 = sum;
            start += sumstr.length();
            sum = b1.add(b2);
            sumstr = sum.toString();
        }
        if(start == num.length()) {
            return true;
        } else {
            return false;
        }
    }
}
