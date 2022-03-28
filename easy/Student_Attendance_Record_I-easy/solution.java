/*

You are given a string representing an attendance record for a student. 
The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) 
or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False

*/

class Solution {
    public boolean checkRecord(String s) {
        int cnt_A = 0;
        int cnt_L = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'A') {
                cnt_A++;
                cnt_L = 0;
            } else if(c == 'P') {
                cnt_L = 0;
            } else {
                cnt_L++;
                if(cnt_L > 2) return false;
            }
        }
        return cnt_A <= 1;
    }
}
