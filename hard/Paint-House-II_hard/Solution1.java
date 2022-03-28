public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int min = 0, nextMin = 0;
        int minId = -1;
        for(int i=0; i<n; i++) {
            int curMin = Integer.MAX_VALUE, curNextMin = Integer.MAX_VALUE;
            int curId = -1;
            for(int j=0; j<k; j++) {
                int val = costs[i][j] + ((j == minId)? nextMin : min);
                if(curId == -1) {
                    curMin = val;
                    curId = j;
                } else if(val < curMin) {
                    curNextMin = curMin;
                    curMin = val;
                    curId = j;
                } else if(val < curNextMin) {
                    curNextMin = val;
                }
            }
            min = curMin;
            nextMin = curNextMin;
            minId = curId;
        }
        return min;
    }
}
