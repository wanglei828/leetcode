/*

X is a good number if after rotating each digit individually by 180 degrees, 
we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 
2 and 5 rotate to each other; 6 and 9 rotate to each other, 
and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation: 
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
Note:

N  will be in range [1, 10000].

*/

class Solution {
    public int rotatedDigits(int N) {
        int cnt = 0;
        int i = 1;
        while(i <= N) {
            if(check(i)) {
                cnt++;
            }
            i++;
        }
        return cnt;
    }
    
    private boolean check(int num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '0':
                case '1':
                case '8': c = c; break;
                case '2': c = '5'; break;
                case '5': c = '2'; break;
                case '6': c = '9'; break;
                case '9': c = '6'; break;
                default:
                    return false;
            }
            sb.append(c);
        }
        return !s.equals(sb.toString());
    }
}
