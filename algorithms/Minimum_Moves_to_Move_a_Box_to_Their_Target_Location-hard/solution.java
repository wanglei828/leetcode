/*
A storekeeper is a game in which the player pushes boxes around in a warehouse trying to get them to target locations.

The game is represented by an m x n grid of characters grid where each element is a wall, floor, or box.

Your task is to move the box 'B' to the target position 'T' under the following rules:

The character 'S' represents the player. The player can move up, down, left, right in grid if it is a floor (empty cell).
The character '.' represents the floor which means a free cell to walk.
The character '#' represents the wall which means an obstacle (impossible to walk there).
There is only one box 'B' and one target cell 'T' in the grid.
The box can be moved to an adjacent free cell by standing next to the box and then moving in the direction of the box. This is a push.
The player cannot walk through the box.
Return the minimum number of pushes to move the box to the target. If there is no way to reach the target, return -1.

Input: grid = [["#","#","#","#","#","#"],
               ["#","T","#","#","#","#"],
               ["#",".",".","B",".","#"],
               ["#",".","#","#",".","#"],
               ["#",".",".",".","S","#"],
               ["#","#","#","#","#","#"]]
Output: 3
Explanation: We return only the number of times the box is pushed.

Input: grid = [["#","#","#","#","#","#"],
               ["#","T","#","#","#","#"],
               ["#",".",".","B",".","#"],
               ["#","#","#","#",".","#"],
               ["#",".",".",".","S","#"],
               ["#","#","#","#","#","#"]]
Output: -1

nput: grid = [["#","#","#","#","#","#"],
               ["#","T",".",".","#","#"],
               ["#",".","#","B",".","#"],
               ["#",".",".",".",".","#"],
               ["#",".",".",".","S","#"],
               ["#","#","#","#","#","#"]]
Output: 5
Explanation: push the box down, left, left, up and up.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
grid contains only characters '.', '#', 'S', 'T', or 'B'.
There is only one character 'S', 'B', and 'T' in the grid.
*/

class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] target = new int[2];
        int[] box = new int[2];
        int[] player = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    box = new int[]{i, j};
                } else if (grid[i][j] == 'S') {
                    player = new int[]{i, j};
                } else if (grid[i][j] == 'T') {
                    target = new int[]{i, j};
                }
            }
        }
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> step = new HashMap<>();
        String key = getKey(box[0], box[1], player[0], player[1]);
        step.put(key, 0);
        q.add(key);
        int res = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (step.containsKey(cur) && step.get(cur) >= res) {
                continue;
            }
            String[] status = cur.split(":");
            int xb = Integer.parseInt(status[0]);
            int yb = Integer.parseInt(status[1]);
            int xp = Integer.parseInt(status[2]);
            int yp = Integer.parseInt(status[3]);
            if (xb == target[0] && yb == target[1]) {
                res = Math.min(res, step.get(cur));
            }
            for (int k = 0; k < 4; k++) {
                int nxp = xp + dirs[k][0];
                int nyp = yp + dirs[k][1];
                if (nxp < 0 || nxp >= m || nyp < 0 || nyp >= n || grid[nxp][nyp] == '#') {
                    continue;
                }
                if (nxp == xb && nyp == yb) {
                    int nxb = xb + dirs[k][0];
                    int nyb = yb + dirs[k][1];
                    if (nxb < 0 || nxb >= m || nyb < 0 || nyb >= n || grid[nxb][nyb] == '#') {
                        continue;
                    }
                    String nkey = getKey(nxb, nyb, nxp, nyp);
                    if (step.containsKey(nkey) && step.get(nkey) <= step.get(cur)) {
                        continue;
                    }
                    step.put(nkey, step.get(cur) + 1);
                    q.add(nkey);
                } else {
                    String nkey = getKey(xb, yb, nxp, nyp);
                    if (step.containsKey(nkey) && step.get(nkey) <= step.get(cur)) {
                        continue;
                    }
                    step.put(nkey, step.get(cur));
                    q.add(nkey);
                }
            }
        }
        return res == Integer.MAX_VALUE? -1 : res;
    }
    
    private String getKey(int bx, int by, int px, int py) {
        return String.valueOf(bx) + ":" + String.valueOf(by) + ":" + String.valueOf(px) + ":" + String.valueOf(py);
    }
}
