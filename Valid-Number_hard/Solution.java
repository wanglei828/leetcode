/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.
*/

public class Solution {
    public boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        if(s.length() == 0) return false;
        int n = s.length();
        boolean hasSign=false, hasDigit=false, hasDot=false, hasE=false;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c >= '0' && c<='9') {
                hasSign = true;
                hasDigit = true;
            } else {
                switch(c) {
                    case '.':
                        if(hasDot || hasE) {
                            return false;
                        }
                        hasSign = true;
                        hasDot = true;
                        break;
                    case 'e':
                        if(hasE || !hasDigit) {
                            return false;
                        }
                        hasE = true;
                        hasSign = false;
                        hasDot = true;
                        hasDigit = false;
                        break;
                        
                    case '+':
                    case '-':
                        if(hasSign) {
                            return false;
                        }
                        hasSign = true;
                        break;
                    default:
                        return false;
                }
            }
        }
        return hasDigit;
    }
}
