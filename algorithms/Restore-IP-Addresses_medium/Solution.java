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
        helper(s, 4, null);
        return res;
    }
    
    private void helper(String s, int k, StringBuilder sb) {
        if(s.length() == 0 && k == 0) {
            res.add(sb.toString());
            return;
        }
        if(s != null && s.length() < k) return;
        String old = (sb != null)? sb.toString() : null; 
        for(int i=1; i<=s.length() && i<=3; i++) {
            String sub = s.substring(0,i);
            if(sub.length()>=2 && sub.charAt(0) == '0') break; //invalid num
            int val = Integer.parseInt(sub);
            if(val>=0 && val <= 255) {
                StringBuilder newsb = new StringBuilder();
                if(old != null) {
                    newsb.append(old);
                    newsb.append(".");
                    newsb.append(sub);
                } else{
                    newsb.append(sub);
                }
                k--;
                helper(s.substring(i), k, newsb);
                k++;
            }
        }
    }
}
