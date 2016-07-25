/*
You are given a string, s, and a list of words, words, that are all of the same length. 
Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and 
without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = s.length();
        int n = words.length;
        int w = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String str:words) {
            if(map.containsKey(str)) {
                map.put(str, map.get(str)+1);
            } else {
                map.put(str, 1);
            }
        }
        for(int i=0; (i+n*w)<=m; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for(int j=0; j<n; j++) {
                String str = s.substring(i+j*w, i+j*w+w);
                if(copy.containsKey(str)) {
                    if(copy.get(str) == 1) {
                        copy.remove(str);
                    } else {
                        copy.put(str, copy.get(str)-1);
                    }
                } else {
                    break;
                }
                if(copy.isEmpty()) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
