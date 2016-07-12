/*
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.size()<2 || map.containsKey(c)) {
                map.put(c, i);
            } else {
                char cur;
                int min = Integer.MAX_VALUE;
                for(Character key:map.keySet()) {
                    if(min>map.get(key)) {
                        min = map.get(key);
                        cur = key;
                    }
                }
                start = map.get(cur) + 1;
                map.remove(cur);
                map.put(c, i);
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}
