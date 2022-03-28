/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() < 4 || s.length() > 12) return res;
        StringBuilder sb = new StringBuilder();
        helper(s, 4, sb);
        return res;
    }
    
    private void helper(String s, int k, StringBuilder sb) {
        if(s.length() == 0 && k == 0) {
            res.add(sb.toString());
            return;
        }
        if(s != null && s.length() < k) return;
        int len = sb.length();
        for(int i=1; i<=s.length() && i<=3; i++) {
            String sub = s.substring(0,i);
            if(sub.length()>=2 && sub.charAt(0) == '0') break; //invalid num
            int val = Integer.parseInt(sub);
            if(val>=0 && val <= 255) {
                if(len > 0) {
                    sb.append(".");
                    sb.append(sub);
                } else{
                    sb.append(sub);
                }
                helper(s.substring(i), k-1, sb);
                sb.setLength(len);
            }
        }
    }
}
