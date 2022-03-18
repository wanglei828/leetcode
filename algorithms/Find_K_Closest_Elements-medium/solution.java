/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int h = 0;
        int t = arr.length-1;
        int f = -1;
        while(h <= t) {
            int m = h + (t-h)/2;
            if (arr[m] == x) {
                f = m;
                break;
            } else if (arr[m] > x) {
                t = m-1;
            } else {
                h = m+1;
            }
        }
        if (f == -1) {
            if (t < 0) {
                f = h;
            } else if (h >= arr.length) {
                f = t;
            } else {
                if (Math.abs(arr[t] - x) <= Math.abs(arr[h] - x)) {
                    f = t;
                } else {
                    f = h;
                }
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        res.add(arr[f]);
        k--;
        int left = f-1;
        int right = f+1;
        while( k > 0) {
            if (left >= 0 && right < arr.length) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    res.addFirst(arr[left]);
                    left--;
                } else {
                    res.addLast(arr[right]);
                    right++;
                }
            } else if (left < 0) {
                res.addLast(arr[right]);
                right++;
            } else {
                res.addFirst(arr[left]);
                left--;
            }
            k--;
        }
        return res;
    }
}
