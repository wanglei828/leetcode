/*
You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. 
Suggested products should have common prefix with searchWord. 
If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.

 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 

Constraints:

1 <= products.length <= 1000
1 <= products[i].length <= 3000
1 <= sum(products[i].length) <= 2 * 104
All the strings of products are unique.
products[i] consists of lowercase English letters.
1 <= searchWord.length <= 1000
searchWord consists of lowercase English letters.
*/

class Solution {
    class TrieNode {
        TrieNode[] next;
        String word;
        public TrieNode() {
            next = new TrieNode[26];
            word = null;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String s : products) {
            insert(root, s);
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            TrieNode cur = root;
            for (int j = 0; j < i; j++) {
                char c = searchWord.charAt(j);
                if (cur.next[c - 'a'] == null) {
                    cur = null;
                    break;
                } else {
                    cur = cur.next[c - 'a'];
                }                
            }
            List<String> list = new ArrayList<>();
            if (cur != null) {
                find(cur, list);
            } 
            res.add(list);
        }
        return res;
    }
    
    private void insert(TrieNode root, String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new TrieNode();
            }
            cur = cur.next[c - 'a'];
        }
        cur.word = s;
    }
    
    private void find(TrieNode cur, List<String> list) {
        if (list.size() == 3) return;
        if (cur.word != null) {
            list.add(cur.word);
        }
        for (int i = 0; i < 26; i++) {
            if (cur.next[i] != null) {
                find(cur.next[i], list);
            }
        }
    } 
}
