/*

Given two strings S and T, return if they are equal when both are typed into empty text editors. 
# means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.

*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        String s = convert(S);
        String t = convert(T);
        return s.equals(t);
    }
    
    private String convert(String str) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c != '#') {
                s.push(c);
            } else {
                if(!s.isEmpty()) {
                    s.pop();
                }
            }
        }
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }
}
