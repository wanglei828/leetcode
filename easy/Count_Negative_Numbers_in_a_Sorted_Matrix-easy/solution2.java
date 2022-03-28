class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = m-1; i >= 0; i--) {
            if (grid[i][n-1] < 0) {
                q.add(new int[]{i,n-1});
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            res++;
            int i = cur[0];
            int j = cur[1];
            if (j == 0) {
                continue;
            }
            if (grid[i][j-1] < 0) {
                q.add(new int[]{i, j-1});
            }
        }
        return res;
    }

}
