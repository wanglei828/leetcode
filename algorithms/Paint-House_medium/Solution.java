/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.
*/

public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length;
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp0[0] = costs[0][0];
        dp1[0] = costs[0][1];
        dp2[0] = costs[0][2];
        for(int i=1; i<n; i++) {
            dp0[i] = Math.min(dp1[i-1], dp2[i-1]) + costs[i][0];
            dp1[i] = Math.min(dp0[i-1], dp2[i-1]) + costs[i][1];
            dp2[i] = Math.min(dp0[i-1], dp1[i-1]) + costs[i][2];
        }
        return Math.min(dp0[n-1], Math.min(dp1[n-1], dp2[n-1]));
    }
}
