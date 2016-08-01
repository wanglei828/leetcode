/*
Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
*/

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0) return 0;
        int cnt = 0;
        int n = nums.length;
        long[][] sum = new long[n+1][2];
        for(int i=1; i<=n; i++) {
            sum[i][0] = sum[i-1][0] + nums[i-1];
            sum[i][1] = i;
        }
        Arrays.sort(sum, new Comparator<long[]>(){
            @Override
            public int compare(long[] s1, long[] s2) {
                if(s1[0] == s2[0]) {
                    return (s1[1] < s2[1])? -1 : 1;
                } else {
                    return (s1[0] < s2[0])? -1 : 1;
                }
            }
            
        });
        for(int i=0; i<=n; i++) {
            long low = sum[i][0] + lower;
            long up = sum[i][0] + upper;
            int h = findlow(sum, low);
            int t = findup(sum, up);
            for(int j=h; j<=t; j++) {
                if(sum[j][1] > sum[i][1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    private int findlow(long[][] sum, long low) {
        int h = 0;
        int t = sum.length - 1;
        while(h<t) {
            int m = h + (t-h)/2;
            if(sum[m][0] >= low) {
                t = m-1;
            } else {
                h = m+1;
            }
        }
        return (sum[h][0]<low)? h+1 : h;
    }
    
    private int findup(long[][] sum, long up) {
        int h = 0;
        int t = sum.length - 1;
        while(h<t) {
            int m = h + (t-h)/2;
            if(sum[m][0] <= up) {
                h = m+1;
            } else {
                t = m-1;
            }
        }
        return (sum[h][0] > up)? h-1 : h;
    }
}
