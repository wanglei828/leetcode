/*
Given a string s and a dictionary of words dict, 
add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

public class Solution {
    
    Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        int n = s.length();
        for(int i=1; i<=n; i++) {
            String sub = s.substring(0, i);
            if(!wordDict.contains(sub)) continue;
            if(i == n) {
                res.add(sub);
                return res;
            }
            List<String> list = null;
            if(map.containsKey(n-i)) {
                list = map.get(n-i);
            } else {
                list = wordBreak(s.substring(i), wordDict);
                map.put(n-i, list);
            }
            if(!list.isEmpty()) {
                for(String str: list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(sub);
                    sb.append(" ");
                    sb.append(str);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }

}
