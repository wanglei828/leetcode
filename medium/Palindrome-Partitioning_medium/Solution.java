/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) return res;
        for(int i=1; i<=s.length(); i++) {
            String sub = s.substring(0,i);
            if(valid(sub)) {
                List<List<String>> next = partition(s.substring(i, s.length()));
                if(next.isEmpty()) {
                    List<String> list = new ArrayList<String>();
                    list.add(sub);
                    res.add(list);
                } else {
                    for(List<String> item:next) {
                        List<String> tmp = new ArrayList<String>();
                        tmp.add(sub);
                        for(String str: item) {
                            tmp.add(str);
                        }
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean valid(String s) {
        if(s == null) return false;
        if(s.length() == 1) return true;
        int h = 0;
        int t = s.length()-1;
        while(h<=t) {
            if(s.charAt(h) != s.charAt(t)) {
                return false;
            }
            h++;
            t--;
        }
        return true;
    }
}
