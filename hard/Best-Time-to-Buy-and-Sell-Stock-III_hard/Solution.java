/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int profit = 0;
        int n = prices.length;
        int[] bMax = new int[n];
        int[] aMax = new int[n];
        bMax[0] = 0;
        aMax[n-1] = 0;
        int min = prices[0];
        int max = prices[n-1];
        for(int i=1; i<n; i++) {
            min = Math.min(min, prices[i]);
            bMax[i] = Math.max(bMax[i-1], prices[i]-min);
        }
        for(int i=n-2; i>=0; i--) {
            max = Math.max(max, prices[i]);
            aMax[i] = Math.max(aMax[i+1], max - prices[i]);
        }
        for(int i=0; i<n; i++) {
            profit = Math.max(profit, bMax[i] + aMax[i]);
        }
        return profit;
    }
}
