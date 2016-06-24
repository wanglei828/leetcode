/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        int org = x;
        int newx = 0;
        while(x>0) {
            newx = newx*10 + x%10;
            x = x/10;
        }
        return newx == org;
    }
}
