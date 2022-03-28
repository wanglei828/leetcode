/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i=0; i<=s.length(); i++) {
            if(!dp[i]) continue;
            for(String str: wordDict) {
                int len = str.length();
                if(i + len> s.length()) {
                    continue;
                }
                if(dp[i+len]) continue;
                if(s.substring(i, i+len).equals(str)){
                    dp[i+len] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
