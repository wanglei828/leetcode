/*
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
*/

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        int flag = 0;
        for(Character c: map.keySet()) {
            int v = map.get(c);
            if(v%2 != 0) {
                if(flag == 0) {
                    flag = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
