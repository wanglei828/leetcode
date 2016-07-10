/*
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/

public class Solution {
    private List<String> res = new ArrayList<String>();
    public List<String> generateAbbreviations(String word) {
        if(word == null) return res;
        StringBuilder sb = new StringBuilder();
        dfs(word, sb, 0, 0);
        return res;
    }
    
    private void dfs(String word, StringBuilder sb, int i, int num) {
        int len = sb.length();
        if(i == word.length()) {
            if(num != 0) sb.append(num);
            res.add(sb.toString());
        } else {
            dfs(word, sb, i+1, num+1);
            char c = word.charAt(i);
            if(num != 0) sb.append(num);
            sb.append(c);
            dfs(word, sb, i+1, 0);
        }
        sb.setLength(len);
    }
}
