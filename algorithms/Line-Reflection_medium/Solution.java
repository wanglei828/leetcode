/*
Given n points on a 2D plane, 
find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?
*/

public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0)  return true;
        int m = points.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<m; i++) {
            int x = points[i][0];
            int y = points[i][1];
            max = Math.max(max, x);
            min = Math.min(min, x);
            if(map.containsKey(x)) {
                map.get(x).add(y);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(y);
                map.put(x, list);
            }
        }
        long sum = (long)max + (long)min;
        for(Integer key: map.keySet()) {
            if(key == (int)(sum-key)) continue;
            for(Integer i: map.get(key)) {
                if(map.containsKey((int)(sum-key)) && map.get((int)(sum-key)).contains(i)) {
                    map.get((int)(sum-key)).remove(i);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
