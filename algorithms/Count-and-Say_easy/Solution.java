/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        if(n<=0) return null;
        if(n==1) return "1";
        if(n==2) return "11";
        String pre = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=0; i < pre.length()-1; i++) {
            if(pre.charAt(i) == pre.charAt(i+1)) {
                count++;
                if(i == pre.length()-2) {
                    sb.append(Integer.toString(count));
                    sb.append(Character.toString(pre.charAt(i)));
                    break;
                }
            } else {
                sb.append(Integer.toString(count));
                sb.append(Character.toString(pre.charAt(i)));
                count = 1;
                if(i == pre.length()-2) {
                    sb.append(Integer.toString(count));
                    sb.append(Character.toString(pre.charAt(i+1)));
                    break;
                }
            }
        }
        return sb.toString();
    }
}
