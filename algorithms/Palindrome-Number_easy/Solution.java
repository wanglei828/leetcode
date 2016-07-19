/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x>=0 && x<=9) return true;
        long y = (long)x;
        long z = 0;
        while(x>0) {
            z = z*10 + x%10;
            x = x/10;
        }
        return y == z;
    }
}
