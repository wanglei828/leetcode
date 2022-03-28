/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, 
such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.
*/

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null || str == null) return false;
        Map<Character, String> fmap = new HashMap<Character, String>();
        Map<String, Character> bmap = new HashMap<String, Character>();
        return helper(0, pattern, 0, str, fmap, bmap);
    }
    
    private boolean helper(int ps, String pattern, int ss, String str, Map<Character, String> fmap, Map<String, Character> bmap) {
        if(ps == pattern.length() && ss == str.length()) {
            return true;
        }
        if(ps == pattern.length() || ss == str.length()) {
            return false;
        }
        char pchar = pattern.charAt(ps);
        for(int i=ss; i<str.length(); i++) {
            String sub = str.substring(ss, i+1);
            if(fmap.containsKey(pchar) && bmap.containsKey(sub)) {
                String pstr = fmap.get(pchar);
                char bchar = bmap.get(sub);
                if(!pstr.equals(sub) || bchar != pchar) {
                    continue;
                }
                if(helper(ps+1, pattern, i+1, str, fmap, bmap)) {
                    return true;
                }
            } else if(!fmap.containsKey(pchar) && !bmap.containsKey(sub)) {
                fmap.put(pchar, sub);
                bmap.put(sub, pchar);
                if(helper(ps+1, pattern, i+1, str, fmap, bmap)) {
                    return true;
                }
                fmap.remove(pchar);
                bmap.remove(sub);
            } 
        }
        return false;
    }
}
