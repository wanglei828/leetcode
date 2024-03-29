/*
You are given a 0-indexed integer array nums of length n. 
The number of ways to partition nums is the number of pivot indices that satisfy both conditions:

1 <= pivot < n
nums[0] + nums[1] + ... + nums[pivot - 1] == nums[pivot] + nums[pivot + 1] + ... + nums[n - 1]
You are also given an integer k. You can choose to change the value of one element of nums to k, or to leave the array unchanged.

Return the maximum possible number of ways to partition nums to satisfy both conditions after changing at most one element.

 

Example 1:

Input: nums = [2,-1,2], k = 3
Output: 1
Explanation: One optimal approach is to change nums[0] to k. The array becomes [3,-1,2].
There is one way to partition the array:
- For pivot = 2, we have the partition [3,-1 | 2]: 3 + -1 == 2.
Example 2:

Input: nums = [0,0,0], k = 1
Output: 2
Explanation: The optimal approach is to leave the array unchanged.
There are two ways to partition the array:
- For pivot = 1, we have the partition [0 | 0,0]: 0 == 0 + 0.
- For pivot = 2, we have the partition [0,0 | 0]: 0 + 0 == 0.
Example 3:

Input: nums = [22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14], k = -33
Output: 4
Explanation: One optimal approach is to change nums[2] to k. The array becomes [22,4,-33,-20,-15,15,-16,7,19,-10,0,-13,-14].
There are four ways to partition the array.
 

Constraints:

n == nums.length
2 <= n <= 105
-105 <= k, nums[i] <= 105
*/

class Solution {
    public int waysToPartition(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i != n-1) {
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        if (sum % 2 == 0) {
            res = sumMap.getOrDefault(sum/2, 0);
        }
        Map<Integer, Integer> preMap = new HashMap<>();
        int presum = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // gradually remove all the sum before nums[i]
                sumMap.put(presum, sumMap.get(presum) - 1);
                preMap.put(presum, preMap.getOrDefault(presum, 0) + 1);
            }
            int new_sum = sum - nums[i] + k;
            if (new_sum % 2 != 0) {
                presum += nums[i];
                continue;
            }
            int target = new_sum / 2;
            int cnt = 0;
            // check value before nums[i]
            cnt += preMap.getOrDefault(target, 0);
            // check value include nums[i] after num[i] change to k
            cnt += sumMap.getOrDefault(target - (k - nums[i]), 0);
            res = Math.max(res, cnt);
            presum += nums[i];
        }
        return res;
    }
}
