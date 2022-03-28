/*

Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

Each rectangle is represented as a bottom-left point and a top-right point. 
For example, a unit square is represented as [1,1,2,2]. 
(coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).

Example 1:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]

Return true. All 5 rectangles together form an exact cover of a rectangular region.

Example 2:

rectangles = [
  [1,1,2,3],
  [1,3,2,4],
  [3,1,4,2],
  [3,2,4,4]
]

Return false. Because there is a gap between the two rectangular regions.

Example 3:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [3,2,4,4]
]

Return false. Because there is a gap in the top center.

Example 4:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [2,2,4,4]
]

Return false. Because two of the rectangles overlap with each other.

*/

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) return false;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX=Integer.MIN_VALUE, maxY=Integer.MIN_VALUE, area=0;
        Set<String> set = new HashSet<>();
        for(int[] cur: rectangles ) {
            minX = Math.min(minX, cur[0]);
            minY = Math.min(minY, cur[1]);
            maxX = Math.max(maxX, cur[2]);
            maxY = Math.max(maxY, cur[3]);
            String p1 = String.valueOf(cur[0]) + "," + String.valueOf(cur[1]);
            String p2 = String.valueOf(cur[0]) + "," + String.valueOf(cur[3]);
            String p3 = String.valueOf(cur[2]) + "," + String.valueOf(cur[1]);
            String p4 = String.valueOf(cur[2]) + "," + String.valueOf(cur[3]);
            if(set.contains(p1)) {
                set.remove(p1);
            } else {
                set.add(p1);
            }
            if(set.contains(p2)) {
                set.remove(p2);
            } else {
                set.add(p2);
            }
            if(set.contains(p3)) {
                set.remove(p3);
            } else {
                set.add(p3);
            }
            if(set.contains(p4)) {
                set.remove(p4);
            } else {
                set.add(p4);
            }
            area += (cur[3] - cur[1]) * (cur[2] - cur[0]);
        }
        String p1 = String.valueOf(minX) + "," + String.valueOf(minY);
        String p2 = String.valueOf(minX) + "," + String.valueOf(maxY);
        String p3 = String.valueOf(maxX) + "," + String.valueOf(minY);
        String p4 = String.valueOf(maxX) + "," + String.valueOf(maxY);
        if(!set.contains(p1) || !set.contains(p2) || !set.contains(p3) || !set.contains(p4) || set.size() != 4) return false;
        return area == (maxY - minY)*(maxX - minX);
    }
}
