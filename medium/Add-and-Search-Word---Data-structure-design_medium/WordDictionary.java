/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

class TrieNode {
    TrieNode[] next;
    boolean isEnd;
    public TrieNode() {
        next = new TrieNode[26];
    }
}
public class WordDictionary {
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null || word.length() == 0) return;
        TrieNode tmp = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(tmp.next[c-'a'] != null) {
                tmp = tmp.next[c-'a'];
            } else {
                TrieNode newNode = new TrieNode();
                tmp.next[c-'a'] = newNode;
                tmp = newNode;
            }
        }
        tmp.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(word, root);
    }
    
    private boolean helper(String word, TrieNode cur) {
        if(word == null || word.length() == 0) return cur.isEnd;
        char c = word.charAt(0);
        TrieNode[] curNext = cur.next;
        if(c == '.') {
            boolean res = false;
            for(int j=0; j<26; j++) {
                if(curNext[j] != null) {
                    res = helper(word.substring(1),curNext[j]);
                }
                if(res) {
                    return res;
                }
            }
            return false;
        } else {
            if(curNext[c-'a'] == null) {
                return false;
            } else {
                return helper(word.substring(1),curNext[c-'a']);
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
