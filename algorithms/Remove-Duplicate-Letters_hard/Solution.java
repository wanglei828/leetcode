/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/

public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) return s;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        Deque<Character> q = new LinkedList<Character>();
        for(int i=0; i<n; i++) {
            char cur = s.charAt(i);
            map.put(cur, map.get(cur)-1);
            if(q.isEmpty()) {
                q.add(cur);
            } else {
                if(!q.contains(cur)) {
                    while(!q.isEmpty()) {
                        char last = q.peekLast();
                        if(map.get(last)>0 && last > cur) {
                            q.pollLast();
                        } else {
                            break;
                        }
                    }
                    q.add(cur);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            sb.append(q.poll());
        }
        return sb.toString();
    }
}
