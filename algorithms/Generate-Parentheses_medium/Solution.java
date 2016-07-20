/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

public class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) return res;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        generate(sb, 1, 0, n);
        return res;
    }
    
    private void generate(StringBuilder sb, int left, int right, int n) {
        if(left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        if(left < n) {
            sb.append("(");
            generate(sb, left+1, right, n);
            sb.setLength(len);
        }
        if(left > right) {
            sb.append(")");
            generate(sb, left, right+1, n);
            sb.setLength(len);
        }
    }
}
