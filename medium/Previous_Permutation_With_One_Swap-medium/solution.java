/*

Given an array A of positive integers (not necessarily distinct), 
return the lexicographically largest permutation that is smaller than A, 
that can be made with one swap (A swap exchanges the positions of two numbers A[i] and A[j]).  
If it cannot be done, then return the same array.

 

Example 1:

Input: [3,2,1]
Output: [3,1,2]
Explanation: Swapping 2 and 1.
Example 2:

Input: [1,1,5]
Output: [1,1,5]
Explanation: This is already the smallest permutation.
Example 3:

Input: [1,9,4,6,7]
Output: [1,7,4,6,9]
Explanation: Swapping 9 and 7.
Example 4:

Input: [3,1,1,3]
Output: [1,3,1,3]
Explanation: Swapping 1 and 3.
 

Note:

1 <= A.length <= 10000
1 <= A[i] <= 10000

*/

class Solution {
    public int[] prevPermOpt1(int[] A) {
        if(A == null || A.length == 0) return A;
        int n = A.length;
        int index = -1;
        for(int i=n-1; i>0; i--) {
            if(A[i-1] > A[i]) {
                index = i-1;
                break;
            }
        }
        if(index == -1) return A;
        int maxSmall = index+1;
        for(int j=index+2; j<n; j++) {
            if(A[j] > A[maxSmall] && A[j] < A[index]) {
                maxSmall = j;
            }
        }
        int tmp = A[index];
        A[index] = A[maxSmall];
        A[maxSmall] = tmp;
        return A;
    }
}
