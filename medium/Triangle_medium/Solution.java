/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int min = Integer.MAX_VALUE;
        List<Integer> dl = null;
        for(int i=0; i<triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            if(i == 0) {
                dl = new ArrayList<Integer>();
                for(int j=0; j<list.size(); j++) {
                    dl.add(list.get(i));
                }
            } else {
                List<Integer> cur = new ArrayList<Integer>();
                for(int j=0; j<list.size(); j++) {
                    if(j==0) {
                        cur.add(dl.get(j) + list.get(j));
                    } else if(j== list.size()-1) {
                        cur.add(dl.get(j-1) + list.get(j));
                    } else {
                        cur.add(Math.min(dl.get(j-1), dl.get(j)) + list.get(j));
                    }
                }
                dl = cur;
            }
        }
        for(Integer i: dl) {
            min = Math.min(i, min);
        }
        return min;
    }
}
