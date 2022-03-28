/*
Remove the minimum number of invalid parentheses in order to make the input string valid. 
Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
*/

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null ) return res;
        Queue<String> q = new LinkedList<String>();
        Set<String> visit = new HashSet<String>();
        q.add(s);
        visit.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            if(found) break;
            int size = q.size();
            while(size > 0) {
                size--;
                String str = q.poll();
                if(valid(str)) {
                    res.add(str);
                    found = true;
                }
                if(found) continue;
                for(int i=0; i<str.length();i++) {
                    char c = str.charAt(i);
                    if(c != '(' && c != ')') continue;
                    String tmp = str.substring(0, i) + str.substring(i+1);
                    if(!visit.contains(tmp)) {
                        q.add(tmp);
                        visit.add(tmp);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean valid(String str) {
        int cnt = 0;
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                cnt++;
            } else if(c == ')') {
                cnt--;
            }
            if(cnt <0) return false;
        }
        return cnt == 0;
    }
}
