/*
You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. 
A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals 
the distance between i and k (the order of the tuple matters).

Return the number of boomerangs.

 

Example 1:

Input: points = [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
Example 2:

Input: points = [[1,1],[2,2],[3,3]]
Output: 2
Example 3:

Input: points = [[1,1]]
Output: 0
 

Constraints:

n == points.length
1 <= n <= 500
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
*/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0 ; j < points.length; j++) {
                if (i == j) continue;
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                    (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (map.containsKey(dis)) {
                    map.put(dis, map.get(dis) + 1);
                } else {
                    map.put(dis, 1);
                }
            }
            for (int dis : map.keySet()) {
                int cnt = map.get(dis);
                res += cnt*(cnt-1);
            }
        }
        return res;
    }
}
