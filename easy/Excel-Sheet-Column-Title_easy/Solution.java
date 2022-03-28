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
        if(n<=0) return "";
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            if(n%26 == 0) {
                sb.insert(0, "Z");
                n -= 26;
                n /= 26;
            } else {
                sb.insert(0, (char)(n%26 + 'A' -1));
                n /=26;
            }
        }
        return sb.toString();
    }
}
