public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null || s.length() != t.length()) return false;
        int[] scnt = new int[26];
        int[] tcnt = new int[26];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            scnt[c-'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            tcnt[c-'a']++;
        }
        for(int i=0; i<26; i++) {
            if(scnt[i] != tcnt[i]) {
                return false;
            }
        }
        return true;
    }
}
