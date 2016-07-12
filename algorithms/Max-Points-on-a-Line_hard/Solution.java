/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        int max = 0;
        int n = points.length;
        if(n == 1) return 1;
        for(int i=0; i<n-1; i++) {
            Point p1 = points[i];
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int same = 0;
            int curMax = 0;
            for(int j=i+1; j<n; j++) {
                Point p2 = points[j];
                if(p1.x == p2.x && p1.y == p2.y) {
                    same++;
                    continue;
                }
                double slope;
                if(p1.y == p2.y) {
                    slope = 0;
                } else if(p1.x == p2.x) {
                    slope = Double.MAX_VALUE;
                } else {
                    slope = ((double)p1.y-(double)p2.y)/((double)p1.x-(double)p2.x);
                }
                if(map.containsKey(slope)) {
                    map.put(slope, map.get(slope)+1);
                } else {
                    map.put(slope, 2);
                }
                curMax = Math.max(curMax, map.get(slope));
            }
            curMax = (curMax == 0)? same+1 : curMax+same;
            max = Math.max(curMax, max);
        }
        return max;
    }
}
