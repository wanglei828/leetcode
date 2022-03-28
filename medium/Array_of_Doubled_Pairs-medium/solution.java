/*
Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for 
every 0 <= i < len(arr) / 2, or false otherwise.

 

Example 1:

Input: arr = [3,1,3,6]
Output: false
Example 2:

Input: arr = [2,1,2,6]
Output: false
Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 

Constraints:

2 <= arr.length <= 3 * 104
arr.length is even.
-105 <= arr[i] <= 105
*/

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // Java’s library doesn’t provide a sort function for ints with comparators
        // comparators can be used only with objects
        Integer[] B = new Integer[arr.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = arr[i];
        }
        Arrays.sort(B, (a, b)->{ return Math.abs(a) - Math.abs(b);});
        for (int num : B) {
            if (map.get(num) == 0) continue;
            if (!map.containsKey(num*2) || map.get(num*2) == 0) {
                return false;
            } else {
                map.put(num, map.get(num) - 1);
                map.put(num*2, map.get(num*2) - 1);
            }
        }
        return true;
    }
}
