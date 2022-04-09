/*
The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, 
return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

 

Example 1:

Input: nums = [1,3,1], k = 1
Output: 0
Explanation: Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Example 2:

Input: nums = [1,1,1], k = 2
Output: 0
Example 3:

Input: nums = [1,6,1], k = 3
Output: 5
 

Constraints:

n == nums.length
2 <= n <= 104
0 <= nums[i] <= 106
1 <= k <= n * (n - 1) / 2
*/

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int h = 0;
        int t = nums[n-1] - nums[0];
        while (h < t) {
            int m = h + (t-h) / 2;
            if (check(nums, m) >= k) {
                t = m;
            } else {
                h = m + 1;
            }
        }
        return h;
    }
    
    private int check(int[] nums, int m) {
        int total = 0;
        int left = 0;
        int right = 0;
        for (right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > m) {
                left++;
            }
            total += right - left;
        }
        return total;
    }
}
