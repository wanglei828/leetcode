/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

public class Solution {
    List<String> res = new ArrayList<String>();
    private String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0 || digits.contains("0") || digits.contains("1")) return new ArrayList<String>();
        helper(digits, 0, new StringBuilder());
        return res;
    }
    private void helper(String digits, int start, StringBuilder sb) {
        if(start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(start);
        String str = nums[c-'0'];
        int len = sb.length();
        for(int i=0; i<str.length(); i++) {
            sb.append(str.charAt(i));
            helper(digits, start+1, sb);
            sb.setLength(len);
        }
    }
}
