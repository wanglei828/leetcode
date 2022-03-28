/*
Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, 
so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<String, Integer>();
        int blank = -1;
        for(int i=0; i<words.length; i++) {
            if("".equals(words[i])) {
                blank = i;
                continue;
            }
            map.put(words[i], i);
        }
        if(blank != -1) {
            for(int i=0; i<words.length; i++) {
                if(i!= blank && isPalin(words[i])) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(blank);
                    list.add(i);
                    res.add(list);
                    list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(blank);
                    res.add(list);
                }
            }
        }
        
        for(int i=0; i<words.length; i++) {
            String str = words[i];
            String revstr = reverse(words[i]);
            if(map.containsKey(revstr) && map.get(revstr) != i) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                list.add(map.get(revstr));
                res.add(list);
            }
            
            for(int j=1; j<str.length(); j++) {
                String sub = str.substring(0,j);
                String left = str.substring(j);
                if(isPalin(sub)) {
                    String revleft = reverse(left);
                    if(map.containsKey(revleft)) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(revleft));
                        list.add(i);
                        res.add(list);
                    }
                }
                if(isPalin(left)) {
                    String revsub = reverse(sub);
                    if(map.containsKey(revsub)) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(revsub));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    
    private String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    
    private boolean isPalin(String str) {
        if(str == null || str.length() == 0) return false;
        int h=0, t=str.length()-1;
        while(h<t) {
            if(str.charAt(h) != str.charAt(t)) return false;
            h++;
            t--;
        }
        return true;
    }
}
