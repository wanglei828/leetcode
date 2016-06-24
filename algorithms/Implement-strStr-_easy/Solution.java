/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        if(needle.length() == 0) return 0;
        if(haystack.length() == needle.length()) {
            if(needle.equals(haystack)) {
                return 0;
            } else {
                return -1;
            }
        }
        if(haystack.length() < needle.length()) return -1;
        for(int i = 0; i < haystack.length(); i++) {
            for(int j = 0; j < needle.length();j++) {
                if(i+j == haystack.length()) {
                    break;
                }
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length()-1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
