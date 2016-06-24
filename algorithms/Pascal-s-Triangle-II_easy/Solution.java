/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> cur = new ArrayList<Integer>();
        int index = 0;
        for(int i = 0; i <= rowIndex; i++) {
            if (index == 0) {
                cur.clear();
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
                index = 1;
            } else {
                pre.clear();
                if(i == 0) {
                    pre.add(1);
                } else if(i == 1) {
                    pre.add(1);
                    pre.add(1);
                } else {
                    pre.add(1);
                    for(int j=1; j<i; j++) {
                        pre.add(cur.get(j-1) + cur.get(j));
                    }
                    pre.add(1);
                }
                index = 0;
            }
        }
        if(index == 1) {
            return cur;
        } else {
            return pre;
        }
    }
}
