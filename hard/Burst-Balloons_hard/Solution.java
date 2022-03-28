/*
Given n balloons, indexed from 0 to n-1. 
Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. 
If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
Credits:
*/

public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] arr = new int[n+2];
        for(int i=1; i<=n; i++) {
            arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[n+1] = 1;
        int[][] dp = new int[n+2][n+2];
        for(int i=1; i<=n; i++) {
            for(int j=i; j>=1; j--) {
                for(int k=j; k<=i; k++) {
                    dp[j][i] = Math.max(arr[j-1]*arr[k]*arr[i+1] + dp[j][k-1] + dp[k+1][i], dp[j][i]);
                }
            }
        }
        return dp[1][n];
    }
}
