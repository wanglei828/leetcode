/*
In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. 
For example, when the root "an" is followed by the successor word "other", we can form a new word "another".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, 
replace all the successors in the sentence with the root forming it. 
If a successor can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
 

Constraints:

1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces.
*/

class Solution {
    class TrieNode {
        TrieNode[] next;
        Boolean isRoot;
        public TrieNode() {
            next = new TrieNode[26];
            isRoot = false;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildDic(dictionary);
        String[] sa = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sa.length; i++) {
            String s = sa[i];
            String sr = findRoot(root, s);
            sb.append(sr);
            if (i != sa.length -1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    
    private TrieNode buildDic(List<String> list) {
        TrieNode root = new TrieNode();
        for (String s : list) {
            insert(root, s);
        }
        return root;
    }
    
    private void insert(TrieNode root, String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.next[c - 'a'] == null) {
                TrieNode node = new TrieNode();
                cur.next[c - 'a'] = node;
                cur = node;
            } else {
                cur = cur.next[c - 'a'];
            }
            if (i == s.length() -1) {
                cur.isRoot = true;
            }
        }
    }
    
    private String findRoot(TrieNode root, String s) {
        TrieNode cur = root;
        int index = 0;
        boolean found = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            index = i;
            if (cur.next[c - 'a']  != null) {
                cur = cur.next[c - 'a'];
                if (cur.isRoot) {
                    found = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (found) {
            return s.substring(0, index+1);  
        } else {
            return s;
        }
        
    }
}
