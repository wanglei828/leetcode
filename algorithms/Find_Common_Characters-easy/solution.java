/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). 
You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
*/

class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[][] cnt = new int[n][26];
        for (int k = 0; k < n; k++) {
            String word = words[k];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cnt[k][c - 'a']++;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, cnt[j][i]);
            }
            if (min != 0) {
                for (int k = 0; k < min; k++) {
                    int c = i + 'a';
                    String s = String.valueOf((char)c);
                    res.add(s);
                }
            }
        }
        return res;
    }
}
