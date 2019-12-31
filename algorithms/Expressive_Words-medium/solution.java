/*

Sometimes people repeat letters to represent extra feeling, 
such as "hello" -> "heeellooo", "hi" -> "hiiii".  
In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, 
a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", 
but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 

 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 

Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters

*/

class Solution {
    public int expressiveWords(String S, String[] words) {
        int cnt = 0;
        for(String word: words) {
            if(check(S, word)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    private boolean check(String S, String word) {
        int i = 0, j=0;
        while(i < S.length() && j < word.length()) {
            int cnt_s = 1;
            while(i+1 < S.length() && S.charAt(i) == S.charAt(i+1)) {
                cnt_s++;
                i++;
            }
            int cnt_w = 1;
            while(j+1 < word.length() && word.charAt(j) == word.charAt(j+1)) {
                cnt_w++;
                j++;
            }
            if(S.charAt(i) == word.charAt(j)) {
                if(cnt_s == cnt_w || (cnt_s > 2 && cnt_s > cnt_w)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return i == S.length() && j == word.length();
    }
}
