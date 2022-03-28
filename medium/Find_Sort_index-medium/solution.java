/*

Given a unsorted array, find the sorting range of the array to make the whole array sorted.

Example 1,
Given array [5, 6, 7, 9, 8, 11, 10, 12, 21, 22]
return [3, 7], beacaue we only need to sort [9, 8, 11, 10, 12] to make the whole array sorted.

Example 2,
Given array [ 5, 6, 7]
return [-1, -1], because the array has already been sorted.

*/

public Class Solution {
  public int[] findIndex(int[] A) {
    if(A == null || A.length == 0) return new int[]{-1, -1};
    int n = A.length;
    int[] minArr = new int[n];
    int[] maxArr = new int[n];
    minArr[n-1] = A[n-1];
    maxArr[0] = A[0];
    for(int i=n-2; i>=0; i--) {
      if(A[i] < minArr[i+1]) {
        minArr[i] = A[i];
      } else {
        minArr[i] = minArr[i+1];
      }
    }
    for(int i=1; i<n; i++) {
      if(A[i] > maxArr[i-1]) {
        maxArr[i] = A[i];
      } else {
        maxArr[i] = maxArr[i-1];
      }
    }
    int start = -1, end = -1;
    for(int i=0; i<n; i++) {
      if(A[i] > minArr[i]) {
        start = i;
        break;
      }
    }
    for(int i=n-1; i>=0; i--) {
      if(A[i] < maxArr[i]) {
        end = i;
        break;
      }
    }
    return new int[]{start, end};
  }
}
