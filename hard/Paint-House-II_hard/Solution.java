/*
There are a row of n houses, each house can be painted with one of the k colors. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color 0; 
costs[1][2] is the cost of painting house 1 with color 2, and so on... 
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?
*/

public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for(int i=0; i<k; i++) {
            dp[0][i] = costs[0][i];
        }
        for(int i=1; i<n; i++) {
            for(int j=0; j<k; j++) {
                int min = Integer.MAX_VALUE;
                for(int m=0; m<k; m++) {
                    if(m != j) {
                        min = Math.min(dp[i-1][m], min);
                    }
                }
                dp[i][j]= min + costs[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int m=0; m<k; m++) {
            min = Math.min(dp[n-1][m], min);
        }       
        return min;
    }
}
