/*

You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.

You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces using K cuts, 
each piece consists of some consecutive chunks.

Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.

Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.

 

Example 1:

Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
Example 2:

Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
Output: 1
Explanation: There is only one way to cut the bar into 9 pieces.
Example 3:

Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
Output: 5
Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 

Constraints:

0 <= K < sweetness.length <= 10^4
1 <= sweetness[i] <= 10^5

*/

class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int min = Integer.MAX_VALUE;
        int sum =0;
        for(int i: sweetness) {
            min = Math.min(min, i);
            sum += i;
        }
        int l = min, h = sum/(K+1);
        while(l <= h) {
            int m = l + (h-l)/2;
            if(check(sweetness, m, K)) {
                l = m+1;
            } else {
                h = m-1;
            }
        }
        return l-1;
    }
    
    private boolean check(int[] s, int m, int k) {
        int tmp = 0, cnt = 0;
        for(int i: s) {
            tmp += i;
            if(tmp >= m) {
                cnt++;
                tmp = 0;
            }
        }
        if(cnt < k+1) {
            return false;
        } else {
            return true;
        }
    }
}
