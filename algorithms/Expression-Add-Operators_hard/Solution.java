/*
Given a string that contains only digits 0-9 and a target value, 
return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/

public class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        dfs(num, sb, 0, 0, 0, target);
        return res;
    }
    
    private void dfs(String num, StringBuilder sb, int start, long prev, long last, int target) {
        if(start == num.length() && prev == (long)target) {
            res.add(sb.toString());
            return;
        }
        for(int i=start+1; i<=num.length(); i++) {
            if(num.charAt(start) == '0' && i > start+1) break;
            long cur = Long.parseLong(num.substring(start, i));
            int len = sb.length();
            if(start == 0) {
                dfs(num, sb.append(cur), i, cur, cur, target);
                sb.setLength(len);
            } else {
                dfs(num, sb.append("+").append(cur), i, prev+cur, cur, target);
                sb.setLength(len);
                dfs(num, sb.append("-").append(cur), i, prev-cur, -cur, target);
                sb.setLength(len);
                dfs(num, sb.append("*").append(cur), i, prev-last+last*cur, last*cur, target);
                sb.setLength(len);
            }
        }
    }
}
