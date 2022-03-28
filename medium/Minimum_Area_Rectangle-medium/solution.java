/*

Given a set of points in the xy-plane, 
determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.

If there isn't any rectangle, return 0.

 

Example 1:

Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4
Example 2:

Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2
 

Note:

1 <= points.length <= 500
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
All points are distinct.

*/

class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0; i<points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if(!map.containsKey(x)) {
                map.put(x, new ArrayList<Integer>());
            }
            map.get(x).add(y);
        }
        int min = Integer.MAX_VALUE;
        Map<String, Integer> pair = new HashMap<>();
        for(Integer x: map.keySet()) {
            List<Integer> list = map.get(x);
            Collections.sort(list);
            for(int i=0; i<list.size(); i++) {
                int y1 = list.get(i);
                for(int j =i+1; j<list.size(); j++) {
                    int y2 = list.get(j);
                    String key = String.valueOf(y1) + "|" + String.valueOf(y2);
                    if(pair.containsKey(key)) {
                        min = Math.min(min, (x-pair.get(key)) * (y2-y1));
                    }
                    pair.put(key, x);
                }
            }
        }
        return (min == Integer.MAX_VALUE)? 0 : min;   
    }
}
