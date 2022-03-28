/*

Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  
Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9

*/

class Solution {
    public String largestTimeFromDigits(int[] A) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(A);
        for(int i=3; i>=0; i--) {
            if(A[i] <= 2) {
                for(int j=3; j>=0; j--) {
                    if((A[i] != 2 || A[j] <= 3) && i != j) {
                        for(int k=3; k>=0; k--) {
                            if(A[k] <= 5 && i !=k && j != k) {
                                sb.append(A[i]);
                                sb.append(A[j]);
                                sb.append(":");
                                sb.append(A[k]);
                                sb.append(A[6-i-j-k]);
                                return sb.toString();
                            }
                        }
                    }
                }
            }
        }
        return "";
    }
}
