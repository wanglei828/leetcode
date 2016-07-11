/*
Given two words (beginWord and endWord), and a dictionary's word list, 
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(beginWord == null && endWord == null) return res;
        if(beginWord.equals(endWord)) return res;
        boolean reach = false;
        Queue<List<String>> q = new LinkedList<List<String>>();
        List<String> list = new ArrayList<String>();
        list.add(beginWord);
        q.add(list);
        while(!q.isEmpty()) {
            int count = q.size();
            Set<String> addSet = new HashSet<String>();
            while(count > 0) {
                List<String> cur = q.poll();
                String str = cur.get(cur.size()-1);
                char[] carry = str.toCharArray();
                for(int i=0; i<carry.length; i++) {
                    boolean find = false;
                    char c = carry[i];
                    for(char j='a'; j<='z'; j++){
                        if(c != j) {
                            carry[i] = j;
                            String tmp = new String(carry);
                            if(tmp.equals(endWord)) {
                                find = true;
                                cur.add(tmp);
                                res.add(cur);
                                break;
                            }
                            if(wordList.contains(tmp)) {
                                addSet.add(tmp);
                                List<String> copy = new ArrayList<String>();
                                for(String s:cur) {
                                    copy.add(s);
                                }
                                copy.add(tmp);
                                q.add(copy);
                            }
                            carry[i] = c; //backtracing.
                        }
                    }
                    if(find) {
                        reach = true;
                        break;
                    }
                }
                count--;
            }
            if(reach){
                break;
            } else {
                for(String s: addSet) {
                   wordList.remove(s); 
                }
            }
        }
        return res;        
    }
}
