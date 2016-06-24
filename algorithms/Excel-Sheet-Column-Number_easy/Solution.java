/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s == "") return 0;
        int num = 0;
        for(int i = 0; i<s.length(); i++) {
            int item = s.charAt(i) - 'A' + 1;
            /*
            if(num> Math.pow(2,31)/26 || (num == Math.pow(2,31)/26 && item>=Math.pow(2,31)%26)) {
                return (int)Math.pow(2,31) -1;
            }*/
            num = num*26 + item;
        }
        return num;
    }
}
