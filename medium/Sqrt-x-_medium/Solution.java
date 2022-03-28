/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
    public int mySqrt(int x) {
        if(x<0) return -1;
        if(x==0) return 0;
        int h = 1;
        int t = x;
        while(h<=t) {
            int mid = h+(t-h)/2;
            if(x/mid>=mid && x/(mid+1)<(mid+1)) {
                return mid;
            } else if(x/mid<mid) {
                t = mid-1;
            } else if(x/mid>mid) {
                h = mid+1;
            }
        }
        return t;
    }
}
