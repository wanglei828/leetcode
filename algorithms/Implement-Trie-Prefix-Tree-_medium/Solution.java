/*
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

class TrieNode {
    TrieNode[] next;
    String word;
    // Initialize your data structure here.
    public TrieNode() {
        next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null) return;
        if(word.length() == 0) return;
        TrieNode tmp = root;
        for(int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(tmp.next[c-'a'] != null) {
                tmp = tmp.next[c-'a'];
            } else {
                TrieNode newNode = new TrieNode();
                tmp.next[c-'a'] = newNode;
                tmp = newNode;
            }
        }
        tmp.isEnd = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tmp = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(tmp.next[c-'a'] == null) {
                return false;
            } else {
                tmp = tmp.next[c-'a'];
            }
        }
        return tmp.word != null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for(int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(tmp.next[c-'a'] == null) {
                return false;
            } else {
                tmp = tmp.next[c-'a'];
            }
        }
        return true;       
    }
    
    //return all the words with same prefix
    public static List<String> findPrefix(String prefix) {
    	List<String> res = new ArrayList<String>();
        TrieNode cur = root;
        for(int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next[c-'a'] == null) {
                return res;
            } else {
                cur = cur.next[c-'a'];
            }
        }
        Queue<TrieNode> q = new LinkedList<TrieNode>();
        q.add(cur);
        while(!q.isEmpty()) {
        	TrieNode node = q.poll();
        	if(node.word != null) {
        		res.add(node.word);
        	}
        	for(TrieNode n : node.next) {
        		if(n != null) {
        			q.add(n);
        		}
        	}
        }
        return res;
    }    
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
