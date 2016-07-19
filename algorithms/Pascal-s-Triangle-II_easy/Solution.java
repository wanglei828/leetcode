/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = null;
        List<Integer> cur = new ArrayList<Integer>();
        int index = 0;
        for(int i = 0; i <= rowIndex; i++) {
            cur = new ArrayList<Integer>();
            if(i == 0) {
                cur.add(1);
            } else if(i == 1) {
                cur.add(1);
                cur.add(1);
            } else {
                cur.add(1);
                for(int j=1; j<i; j++) {
                   cur.add(pre.get(j-1) + pre.get(j));
                }
                cur.add(1);
            }
            pre = cur;
        }
        return cur;
    }
}
