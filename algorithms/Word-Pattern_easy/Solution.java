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
            char pchar = pattern.charAt(i);
            String sub = strArr[i];
            if(fmap.containsKey(pchar) && bmap.containsKey(sub)) {
                String pstr = fmap.get(pchar);
                char schar = bmap.get(sub);
                if(!pstr.equals(sub) || schar != pchar) {
                    return false;
                }
            } else if(!fmap.containsKey(pchar) && !bmap.containsKey(sub)) {
                fmap.put(pchar, sub);
                bmap.put(sub, pchar);
            } else {
                return false;
            }
        }
        return true;
    }
}
