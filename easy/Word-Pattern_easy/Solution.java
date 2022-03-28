/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if(pattern.length() != strArr.length) return false;
        Map<Character, String> fmap = new HashMap<Character, String>();
        Map<String, Character> bmap = new HashMap<String, Character>();
        for(int i=0; i<strArr.length; i++) {
            char p = pattern.charAt(i);
            String s = strArr[i];
            if(fmap.containsKey(p) && bmap.containsKey(s)) {
                if(!fmap.get(p).equals(s) || bmap.get(s) != p) {
                    return false;
                } 
            } else if(!fmap.containsKey(p) && !bmap.containsKey(s)) {
                fmap.put(p, s);
                bmap.put(s, p);
            } else {
                return false;
            }
        }
        return true;
    }
}
