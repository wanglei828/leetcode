/*
Given a string s, return all the palindromic permutations (without duplicates) of it. 
Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].
*/

public class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> generatePalindromes(String s) {
        if(s == null || s.length() == 0) return res;
        if(s.length() == 1) {
            res.add(s);
            return res;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        char single = '\0';
        StringBuilder sb = new StringBuilder();
        for(Character key:map.keySet()) {
            int n = map.get(key);
            for(int i=0; i<n/2; i++) {
                sb.append(key);
            }
            if(n%2 == 1) {
                if(single == '\0') {
                    single = key;
                } else {
                    return res;
                }
            }
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        helper(sb, list, single, null);
        return res;
    }
    private void helper(StringBuilder charSb, LinkedList<Integer> list, char single, StringBuilder sb) {
        if(sb != null && sb.length() == charSb.length()) {
            StringBuilder copy = new StringBuilder(sb);
            StringBuilder reverse = new StringBuilder(sb);
            reverse.reverse();
            if(single != '\0') {
                copy.append(single);
            }
            copy.append(reverse);
            res.add(copy.toString());
            return;
        }
        sb = (sb!=null)? sb : new StringBuilder();
        int size = sb.length();
        int last = -1;
        for(int i=0; i<charSb.length(); i++) {
            if(list.contains(i)) {
                continue;
            }
            if(last != -1 && charSb.charAt(last) == charSb.charAt(i)) {
                continue;
            }
            last = i;
            sb.append(charSb.charAt(i));
            list.add(i);
            helper(charSb, list, single, sb);
            while(list.size() != size) {
                list.pollLast();
            }
            sb.delete(size, sb.length());
        }
    }
}
