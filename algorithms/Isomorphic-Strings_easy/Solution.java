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
        Map<Character, Character> mapS = new HashMap<Character, Character>();
        Map<Character, Character> mapT = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++) {
            char src = s.charAt(i);
            char tar = t.charAt(i);
            if(mapS.containsKey(s.charAt(i))) {
                src = mapS.get(src);
            }
            if (src != tar) {
                if(mapS.containsKey(s.charAt(i))) {
                    return false;
                } else {
                    if(mapT.containsKey(tar)) {
                        return false;
                    } else {
                        mapS.put(src, tar);
                        mapT.put(tar, src);
                    }
                }
            } else {
                if(!mapS.containsKey(s.charAt(i))) {
                    mapS.put(s.charAt(i), tar);
                    mapT.put(tar, s.charAt(i));
                }
            }
        }
        return true;
    }
}
