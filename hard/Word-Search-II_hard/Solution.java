/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

public class Solution {
    class Trie {
        Trie[] next = new Trie[26];
        String word;
    }
    
    private List<String> res = new ArrayList<String>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        buildTrie(words, root);
        
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                find(board, i, j, root);
            }
        }
        return res;
    }
    
    private void find(char[][] board, int i, int j, Trie cur) {
        char c = board[i][j];
        if(c == '#' || cur.next[c-'a'] == null) return;
        cur = cur.next[c-'a'];
        if(cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        board[i][j] = '#';
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int k=0; k<4; k++) {
            int x = i+dir[k][0];
            int y = j+dir[k][1];
            if(x>=0 && x < board.length && y>=0 && y<board[0].length) {
                find(board, x, y, cur);
            }
        }
        board[i][j] = c;
    }
    
    private void buildTrie(String[] words, Trie root) {
        for(String w: words) {
            Trie cur = root;
            char[] arr = w.toCharArray();
            for(int i=0; i<arr.length; i++) {
                if(cur.next[arr[i] - 'a'] == null) {
                    cur.next[arr[i] - 'a'] = new Trie();
                }
                cur = cur.next[arr[i] - 'a'];
            }
            cur.word = w;
        }
    }
}
