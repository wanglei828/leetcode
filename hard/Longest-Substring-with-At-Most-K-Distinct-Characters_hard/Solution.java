/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
*/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k<=0) return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.size() < k || map.containsKey(c)) {
                map.put(c, i);
            } else {
                int min = Integer.MAX_VALUE;
                char cur = '\0';
                for(Character key:map.keySet()) {
                    if(min > map.get(key)) {
                        min = map.get(key);
                        cur = key;
                    }
                }
                start = min + 1;
                map.remove(cur);
                map.put(c, i);
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}
