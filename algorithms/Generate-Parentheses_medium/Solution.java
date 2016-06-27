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
        StringBuilder sb = new StringBuilder();
        generate(sb, 0, 0, n);
        return res;
    }
    
    private void generate(StringBuilder sb, int left, int right, int n) {
        if(left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        if(left < n) {
            if(len == 0) {
                sb.append("(");
                generate(sb, left+1, right, n);
            } else {
                sb.append("(");
                generate(sb, left+1, right, n);
                sb.deleteCharAt(len);
            }
        }
        if(left > right) {
            sb.append(")");
            generate(sb, left, right+1, n);
            sb.deleteCharAt(len);
        }
    }
}
