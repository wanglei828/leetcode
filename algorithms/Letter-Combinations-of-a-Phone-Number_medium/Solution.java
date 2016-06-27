/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

public class Solution {
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
        return helper(map, digits, 0);
    }
    private List<String> helper(Map<Character, String> map, String digits, int start) {
        char c = digits.charAt(start);
        List<String> res = (start == digits.length()-1)? null : helper(map, digits, start+1);
        String str = map.get(c);
        List<String> result = new ArrayList<String>();
        for(int i=0; i<str.length(); i++) {
            if(res != null) {
                for(int j=0; j<res.size();j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(i));
                    sb.append(res.get(j));
                    result.add(sb.toString());
                }
            } else {
                result.add(String.valueOf(str.charAt(i)));
            }
        }
        return result;
    }
}
