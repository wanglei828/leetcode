/*
Given a list of 2d points, if any two points have distance(straight line) <= k , group them together. 
For example. [P1,P2,P3], P1 to P2 <=k, P2 to p3<=k, p1 to p3>k. they are still in the same group. 
(distance relationship is chainable ) ask how many groups can you find ?
*/

class solution {
    public int countCluster(double[][] points, int k) {
        int n = points.length;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        int cnt = n;
        for (int i = 0; i < n; i++) {
            double x = points[i][0];
            double y = points[i][1];
            for (int j = i+1; j < n; j++) {
                double xj = points[j][0];
                double yj = points[j][1];
                if (x*xj + y*yj <= k*k) {
                    int ri = find(roots, i);
                    int rj = find(roots, j);
                    if (ri != rj) {
                        roots[rj] = ri;
                        cnt--;
                    }
                }
            }
        }
        return cnt;
    }

    private int find(int[] roots, int cur) {
        while (roots[cur] != cur) {
            int nr = roots[cur];
            roots[cur] = roots[nr];
            cur = nr;
        }
        return cur;
    }
}
