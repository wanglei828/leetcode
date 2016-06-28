/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/

public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return null;
        String[] strArr = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i=0; i<strArr.length; i++) {
            String s = strArr[i];
            if(s.equals("") || s.equals(".")) {
                continue;
            } else if(s.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    stack.push("/");
                }
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            if(!stack.peek().equals("/")) {
                sb.insert(0, stack.pop());
                sb.insert(0, "/");
            } else {
                stack.pop();
            }
        }
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}
