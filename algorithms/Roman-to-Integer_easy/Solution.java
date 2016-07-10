/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int cur = helper(s.charAt(0));
        int sum = 0;
        for(int i=1; i<s.length(); i++) {
            int next = helper(s.charAt(i));
            if(cur < next) {
                sum -= cur;
            } else {
                sum += cur;
            }
            cur = next;
        }
        sum += cur;
        return sum;
    }
    
    private int helper(char ch) {
        switch (ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
}
