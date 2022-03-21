/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
2 <= k <= 104
*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            while(rem < 0) {
                rem += k;
            }
            if (preSum.containsKey(rem)) {
                res += preSum.get(rem);
                preSum.put(rem, preSum.get(rem) + 1);
            } else {
                preSum.put(rem, 1);
            }
        }
        return res;
    }
}
