/*

Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, 
and consists of W consecutive cards.

Return true if and only if she can.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.
 

Note:

1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length

*/

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if(n%W != 0) return false;
        Arrays.sort(hand);
        Set<Integer> used = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(used.contains(i)) continue;
            used.add(i);
            int j = i+1;
            int k = W-1;
            int p = i;
            while(j < n && k > 0) {
                if(used.contains(j)) {
                    j++;
                    continue;
                }
                if(hand[j] == hand[p] + 1) {
                    used.add(j);
                    p = j;
                    j++;
                    k--;
                } else if(hand[j] == hand[p]) {
                    j++;
                } else {
                    return false;
                }
                
            }
            if(k != 0) return false;
        }
        return true;
    }
}
