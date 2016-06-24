/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder num = new StringBuilder();
        while(n > 0) {
            char tmp;
            if(n%26 == 0) {
                tmp = 'Z';
                n = n/26 - 1;
            } else {
                tmp = (char)('A' - 1 + n%26);
                n = n/26;
            }
            num.append(tmp);
        }
        return num.reverse().toString();
    }
}
