/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
*/

public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int h = 0;
        int t = n-1;
        int res=0;
        while(h<=t) {
            int m = h + (t-h)/2;
            if(citations[m] >= n-m) {
                res = n-m;
                t = m-1;
            } else {
                h = m+1;
            }
        }
        return res;
    }
}
