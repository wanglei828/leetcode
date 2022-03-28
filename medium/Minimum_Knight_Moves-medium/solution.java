/*
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. 
Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.

Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 

Constraints:

|x| + |y| <= 300
*/

class Solution {
    private int[][] dirs = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> q = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        int k = 0;
        q.add(new int[]{0,0});
        visit.add("0|0");
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();
                if(cur[0] == x && cur[1] == y) return k;
                for(int[] d: dirs) {
                    int newx = cur[0] + d[0];
                    int newy = cur[1] + d[1];
                    if(!visit.contains(newx+"|"+newy) && newx >= -2 && newy >= -2) {
                        q.add(new int[]{newx, newy});
                        visit.add(newx+"|"+newy);
                    }
                }
            }
            k++;
        }
        return -1;
    }
}
