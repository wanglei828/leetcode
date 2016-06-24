/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0 ) return false;
        char[] strArr = num.toCharArray();
        int n = strArr.length;
        for(int i=0; i<n; i++) {
            if(strArr[i] == '0' && strArr[n-1-i] == '0' || strArr[i] == '1' && strArr[n-1-i] == '1' || strArr[i] == '6' && strArr[n-1-i] == '9' || strArr[i] == '8' && strArr[n-1-i] == '8' || strArr[i] == '9' && strArr[n-1-i] == '6' ) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
