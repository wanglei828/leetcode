/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if(i == 0) {
                list.add(1);
            } else if(i == 1) {
                list.add(1);
                list.add(1);
            } else {
                list.add(1);
                List<Integer> pre = result.get(i-1);
                for(int j=1; j<i; j++) {
                    list.add(pre.get(j-1) + pre.get(j));
                }
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }
}
