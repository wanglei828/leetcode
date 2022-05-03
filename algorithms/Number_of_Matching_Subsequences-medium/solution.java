/*
Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) 
deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
 

Constraints:

1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.
*/

class Solution {
    class Node {
        String w;
        int index;
        Node(String _w, int i) {
            w = _w;
            index = i;
        }
    }
    public int numMatchingSubseq(String s, String[] words) {
        int cnt = 0;
        List<Node>[] heads = new List[26];
        for (int i = 0; i < 26; i++) {
            heads[i] = new ArrayList<Node>();
        }
        for (String w : words) {
            char c = w.charAt(0);
            heads[c - 'a'].add(new Node(w, 0));
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Node> old_list = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<>();
            for (Node n : old_list) {
                n.index++;
                if (n.index == n.w.length()) {
                    cnt++;
                } else {
                    char cur = n.w.charAt(n.index);
                    heads[cur - 'a'].add(n);
                }
            }
            old_list.clear();
        }
        return cnt;
    }
}
