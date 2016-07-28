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
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0 || digits.contains("0") || digits.contains("1")) return new ArrayList<String>();
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(map, digits, 0, new StringBuilder());
        return res;
    }
    private void helper(Map<Character, String> map, String digits, int start, StringBuilder sb) {
        if(start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(start);
        String str = map.get(c);
        int len = sb.length();
        for(int i=0; i<str.length(); i++) {
            sb.append(str.charAt(i));
            helper(map, digits, start+1, sb);
            sb.setLength(len);
        }
    }
}
