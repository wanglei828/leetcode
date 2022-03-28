/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = max[0];
        for(int i=1; i<len; i++) {
            if(nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i-1]*nums[i]);
                min[i] = Math.min(nums[i], min[i-1]*nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i-1]*nums[i]);
                min[i] = Math.min(nums[i], max[i-1]*nums[i]);
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
