/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null && endWord == null) return 0;
        if(beginWord.equals(endWord)) return 0;
        int step = 1;
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        while(!q.isEmpty()) {
            int count = q.size();
            step++;
            while(count!=0) {
                String str = q.poll();
                char[] carry = str.toCharArray();
                for(int i=0; i<carry.length; i++) {
                    char c = carry[i];
                    for(char j='a'; j<='z'; j++){
                        if(c != j) {
                            carry[i] = j;
                            String tmp = new String(carry);
                            if(tmp.equals(endWord)) {
                                return step;
                            }
                            if(wordList.contains(tmp)) {
                                q.add(tmp);
                                wordList.remove(tmp);
                            }
                        }
                    }
                    carry[i] = c;
                }
                count--;
            }
        }
        return 0;
    }
}
