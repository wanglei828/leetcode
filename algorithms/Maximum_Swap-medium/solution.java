/*

Given a non-negative integer, 
you could swap two digits at most once to get the maximum valued number. 
Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]

*/

class Solution {
    public int maximumSwap(int num) {
        char[] str = String.valueOf(num).toCharArray();
        int[] index = new int[10];
        for(int i=0; i<str.length; i++) {
            index[str[i]-'0'] = i;
        }
        for(int i=0; i<str.length; i++) {
            char c = str[i];
            for(int j=9; j>=0; j--) {
                if(j > c-'0' && index[j] > i) {
                    str[i] = str[index[j]];
                    str[index[j]] = c;
                    return Integer.valueOf(String.valueOf(str));
                }
            }
        }
        return num;
    }
}
