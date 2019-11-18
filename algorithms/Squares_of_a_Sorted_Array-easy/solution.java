/*

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.

*/

class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int neg = -1;
        int pos = 0;
        for(int i=0; i<n; i++) {
            if(A[i] >= 0) {
                pos = i;
                neg = pos -1;
                break;
            }
        }
        int[] res = new int[n];
        int i = 0;
        while(pos <n && neg >= 0) {
            if(A[pos]*A[pos] >= A[neg]*A[neg]) {
                res[i] = A[neg]*A[neg];
                neg--;
            } else {
                res[i] = A[pos]*A[pos];
                pos++;
            }
            i++;
        }
        while(pos<n) {
            res[i] = A[pos]*A[pos];
            pos++;
            i++;
        }
        while(neg>=0) {
            res[i] = A[neg]*A[neg];
            neg--;
            i++;
        }
        return res;
    }
}
