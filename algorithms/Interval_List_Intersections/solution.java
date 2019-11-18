/*

Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:
Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

*/

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i=0, j=0;
        while(i<A.length && j<B.length) {
            int[] a = A[i];
            int[] b = B[j];
            if(a[0] > b[1]) {
                j++;
            } else if (a[1] < b[0]) {
                i++;
            } else {
                int[] tmp = new int[2];
                tmp[0] = Math.max(a[0], b[0]);
                tmp[1] = Math.min(a[1], b[1]);
                list.add(tmp);
                if(b[1] > a[1]) {
                    i++;
                } else if (b[1] < a[1]) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for(i=0; i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
