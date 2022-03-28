/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        String s = strs[0];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int j=0;
            for(; j<strs.length; j++) {
                if(i>= strs[j].length() || strs[j].charAt(i) != c) {
                    break;
                }
            }
            if(j != strs.length) {
                break;
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
