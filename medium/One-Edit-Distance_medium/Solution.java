/*
Given two strings S and T, determine if they are both one edit distance apart.
*/

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null) return t!= null && t.length()==1;
        if(t == null) return s!= null && s.length()==1;
        int sl = s.length();
        int tl = t.length();
        if(Math.abs(tl-sl)>1) return false;
        if(tl == sl) {
            int count = 0;
            for(int i=0; i<sl; i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    count++;
                }
                if(count > 1) {
                    return false;
                }
            }
            return count == 1;
        } else if(sl < tl) {
            int flag = 0;
            int i=0, j=0;
            while(i<sl) {
                if(s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if(flag == 0) {
                        flag = 1;
                        j++;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return isOneEditDistance(t, s);
        }
    }
}
