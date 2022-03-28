/*
A group of two or more people wants to meet and minimize the total travel distance. 
You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

Hint:

Try to solve it in one dimension first. How can this solution apply to the two dimension case?
*/

public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> xpos = new ArrayList<Integer>();
        List<Integer> ypos = new ArrayList<Integer>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1)  {
                    xpos.add(i);
                    ypos.add(j);
                }
            }
        }
        int sum = 0;
        for(Integer i: xpos) {
            sum += Math.abs(i - xpos.get(xpos.size()/2));
        }
        Collections.sort(ypos);
        for(Integer i: ypos) {
            sum += Math.abs(i - ypos.get(ypos.size()/2));
        }
        return sum;
    }
}
