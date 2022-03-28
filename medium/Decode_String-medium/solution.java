/*

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], 
where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, 
square brackets are well-formed, etc.

Furthermore, you may assume that 
the original data does not contain any digits and that digits are only for those repeat numbers, k. 
For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/

class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        String str;
        while(index<s.length()) {
            char c = s.charAt(index);
            if(c >='0' && c<='9') {
                k = k*10 + c - '0';
                index++;
            } else if (c == '[') {
                index++;
                str = decodeString(s);
                for(int j=0; j<k; j++) {
                    sb.append(str);
                }
                k = 0;
            } else if (c == ']') {
                index++;
                return sb.toString();
            } else {
                sb.append(c);
                index++;
            }
        }
        return sb.toString();
    }
}
