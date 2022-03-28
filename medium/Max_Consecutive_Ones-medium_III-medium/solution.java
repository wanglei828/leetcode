/*

Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 

Note:

1 <= A.length <= 20000
0 <= K <= A.length
A[i] is 0 or 1 

*/

class Solution {
    public int longestOnes(int[] A, int K) {
        int res = 0;
        int left = 0, right = 0;
        int curK = K;
        while(right < A.length) {
            if(A[right] == 0) curK--;
            while(curK < 0 && left < A.length) {
                if(A[left] == 0) curK++;
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
}
