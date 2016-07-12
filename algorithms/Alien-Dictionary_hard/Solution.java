/*
There is a new alien language which uses the latin alphabet. 
However, the order among letters are unknown to you. 
You receive a list of words from the dictionary, 
where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/

public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        int[] status = new int[26];
        Arrays.fill(status, -1);
        //get whole character set.
        for(int i=0; i<words.length; i++) {
            String str = words[i];
            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                status[c-'a'] = 0;
            }
        }
        //build relation graph.
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        for(int i=0; i<words.length-1; i++) {
            String str1 = words[i];
            String str2 = words[i+1];
            for(int j=0; j<str1.length() && j<str2.length(); j++) {
                char c1 = str1.charAt(j);
                char c2 = str2.charAt(j);
                if(c1 != c2) {
                    if(map.containsKey(c1)) {
                        if(map.get(c1).add(c2)) {
                            status[c2-'a']++;
                        }
                    } else {
                        Set<Character> set = new HashSet<Character>();
                        set.add(c2);
                        map.put(c1, set);
                        status[c2-'a']++;
                    }
                    break;
                }
            }
        }
        //topology sort
        Queue<Character> q = new LinkedList<Character>();
        for(int i=0; i<26; i++) {
            if(status[i] == 0) {
                q.add(Character.valueOf((char)(i+'a')));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            if(!map.containsKey(c)) continue;
            for(Character c1: map.get(c)) {
                status[c1-'a']--;
                if(status[c1-'a'] == 0) q.add(c1);
            }
        }
        for(int i=0; i<26; i++) {
            if(status[i] >=1) {
                return "";
            }
        }
        return sb.toString();
    }
}
