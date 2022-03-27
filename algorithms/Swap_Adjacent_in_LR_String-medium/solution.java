/*
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or 
replacing one occurrence of "RX" with "XR". 
Given the starting string start and the ending string end, 
return True if and only if there exists a sequence of moves to transform one string to the other.

 

Example 1:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: true
Explanation: We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
Example 2:

Input: start = "X", end = "L"
Output: false
 

Constraints:

1 <= start.length <= 104
start.length == end.length
Both start and end will only consist of characters in 'L', 'R', and 'X'.
*/

class Solution {
    public boolean canTransform(String start, String end) {
        int lcnt = 0;
        int rcnt = 0;
        if (start.length() != end.length()) return false;
        // L in end string should come no later than start
        // R in start string should come no later than end;
        // L, R cannot cross each other
        for (int i = 0; i < start.length(); i++) {
            char sc = start.charAt(i);
            char ec = end.charAt(i);
            if (ec == 'L') {
                if (rcnt > 0) return false;
                lcnt++;
                
            }
            
            if (sc == 'L') {
                if (lcnt <= 0) return false;
                lcnt--;
            }
            
            if (sc == 'R') {
                if (lcnt > 0) return false;
                rcnt++;
            }
            
            if (ec == 'R') {
                if (rcnt <= 0) return false;
                rcnt--;
            }
        }
        return lcnt == 0 && rcnt == 0;
    }
}
