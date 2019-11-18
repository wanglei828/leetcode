/*

Given an array w of positive integers, where w[i] describes the weight of index i, 
write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]

Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. 
Solution's constructor has one argument, the array w. pickIndex has no arguments. 
Arguments are always wrapped with a list, even if there aren't any.

*/

class Solution {
    List<Integer> list;
    Random random;
    int sum = 0;
    public Solution(int[] w) {
        list = new ArrayList<>();
        random = new Random();
        for(int i=0; i<w.length; i++) {
            sum += w[i];
            list.add(sum);
        }
    }
    
    public int pickIndex() {
        int cur = random.nextInt(sum);
        int h = 0, t=list.size()-1;
        while(h != t) {
            int m = h+(t-h)/2;
            if(cur >=list.get(m)) {
                h = m+1;
            } else {
                t = m;
            }
        }
        return h;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
