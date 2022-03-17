/*
There are n cities connected by some number of flights. 
You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. 
If there is no such route, return -1.

*/

class Solution {
    private int[][] adjGraph;
    private HashMap<Pair<Integer, Integer>, Long> mem;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        adjGraph = new int[n][n];
        mem = new HashMap<Pair<Integer, Integer>, Long>();
        for (int[] flight : flights) {
            adjGraph[flight[0]][flight[1]] = flight[2];
        }
        long ans = helper(src, dst, k, n);
        if (ans >= Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int)ans;
        }
    }
    
    private long helper(int src, int dst, int stop, int n) {
        if (src == dst) {
            return 0;
        }
        if (stop < 0) {
            return Integer.MAX_VALUE;
        }
        Pair<Integer, Integer> key = new Pair<Integer, Integer>(src, stop);
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cost = adjGraph[src][i];
            if (cost > 0) {
                ans = Math.min(ans, helper(i, dst, stop-1, n) + cost);
            }
        }
        mem.put(key, ans);
        return ans;
    }
}
