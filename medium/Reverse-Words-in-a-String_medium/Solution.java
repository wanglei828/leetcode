/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

public class Solution {
    public String reverseWords(String s) {
        if(s == null) return null;
        String str = s.trim();
        if(str.length() == 0) return "";
        String[] strArr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=strArr.length-1; i>=0; i--) {
            if(!strArr[i].equals("")) {
                sb.append(strArr[i]);
                if(i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
