/*

Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, 
return a sorted array of only the integers that appeared in all three arrays.

 

Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.
 

Constraints:

1 <= arr1.length, arr2.length, arr3.length <= 1000
1 <= arr1[i], arr2[i], arr3[i] <= 2000

*/

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int i=0, j=0, k=0;
        while(i<arr1.length && j<arr2.length && k<arr3.length) {
            int a1 = arr1[i];
            int a2 = arr2[j];
            int a3 = arr3[k];
            if(a1 == a2 && a1 == a3) {
                ans.add(a1);
                i++;
                j++;
                k++;
            } else if(a1 <= a2 && a1 <= a3) {
                i++;
            } else if(a2 <= a1 && a2 <= a3) {
                j++;
            } else if(a3 <= a1 && a3 <= a2) {
                k++;
            }
        }
        return ans;
    }
}
