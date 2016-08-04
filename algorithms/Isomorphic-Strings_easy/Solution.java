/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        Map<Character, Character> maps = new HashMap<Character, Character>();
        Map<Character, Character> mapt = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++) {
            char src = s.charAt(i);
            char tar = t.charAt(i);
            if(maps.containsKey(src) && mapt.containsKey(tar)) {
                if(maps.get(src) != tar || mapt.get(tar) != src) {
                    return false;
                }
            } else if(!maps.containsKey(src) && !mapt.containsKey(tar)) {
                maps.put(src, tar);
                mapt.put(tar, src);
            } else {
                return false;
            }
        }
        return true;
    }
}
