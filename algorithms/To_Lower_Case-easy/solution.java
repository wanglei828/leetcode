/*

Implement function ToLowerCase() that has a string parameter str, 
and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"

*/

class Solution {
    public String toLowerCase(String str) {
        char[] strArr = str.toCharArray();
        int diff = 'A' - 'a';
        for(int i=0; i<strArr.length; i++) {
            char c = strArr[i];
            if(c >= 'A' && c <= 'Z') {
                strArr[i] = (char)(c-diff);
            }
        }
        return new String(strArr);
    }
}
