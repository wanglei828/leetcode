/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = words.length;
        int l1 = -1;
        int l2 = -1;
        for(int i=0; i<words.length; i++) {
            if(word1.equals(words[i])) {
                l1 = i;
                if(l2 != -1) {
                    min = Math.min(min, Math.abs(l1-l2));
                }
            }
            if(word2.equals(words[i])) {
                l2 = i;
                if(l1 != -1) {
                    min = Math.min(min, Math.abs(l1-l2)); 
                }
            }
        }
        return min;
    }
}
