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
        if(left < n) {
            StringBuilder newsb = new StringBuilder(sb.toString());
            newsb.append("(");
            generate(newsb, left+1, right, n);
        }
        if(left > right) {
            StringBuilder newsb = new StringBuilder(sb.toString());
            newsb.append(")");
            generate(newsb, left, right+1, n);
        }
    }
}
