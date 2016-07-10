/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int count =0;
        int res_s = 0;
        int res_e = 0;
        Map<Character, Integer> cur = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if(cur.containsKey(c)) {
                    if(cur.get(c) < map.get(c)) {
                        count++;
                    }
                    cur.put(c, cur.get(c)+1);
                } else {
                    cur.put(c, 1);
                    count++;
                }
            }
            if(count == t.length()) {
                while(!map.containsKey(s.charAt(start)) || map.get(s.charAt(start)) < cur.get(s.charAt(start))){
                    if(cur.containsKey(s.charAt(start))) {
                        cur.put(s.charAt(start), cur.get(s.charAt(start))-1);
                    }
                    start++;
                }
                if(min > (i-start+1)) {
                    min = i-start+1;
                    res_s = start;
                    res_e = i;
                }
            }
            
        }
        if(count == t.length()) {
            return s.substring(res_s, res_e+1);
        } else {
            return "";
        }
    }
}
