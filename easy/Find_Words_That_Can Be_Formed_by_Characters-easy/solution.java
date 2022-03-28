/*
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
words[i] and chars consist of lowercase English letters.
*/

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] dic = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            dic[c - 'a']++;
        }
        int cnt = 0;
        for (String word : words) {
            if (check(word, dic)) {
                cnt += word.length();
            }
        }
        return cnt;
    }
    
    private boolean check(String s, int[] dic) {
        int[] cur = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cur[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cur[i] > dic[i]) {
                return false;
            }
        }
        return true;
    }
}
