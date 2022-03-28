/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
*/

class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> st = new LinkedList<Character>();
        int n = num.length();
        if (n <= k) {
            return "0";
        }
        for (int i = 0; i < n; i++) {
            char d = num.charAt(i);
            if (st.isEmpty()) {
                st.addLast(d);
            } else {
                while(!st.isEmpty() && k > 0) {
                    if (st.peekLast() > d) {
                        st.removeLast();
                        k--;
                    } else {
                        break;
                    }
                }
                st.addLast(d);
            }
        }
        while( k > 0) {
            st.removeLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for(Character d: st) {
            if (zero && d == '0') continue;
            zero = false;
            sb.append(d);
        }
        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }   
    }
}
