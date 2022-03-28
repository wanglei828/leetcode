/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 import java.util.Random;
public class Solution {

    ListNode head;
    Random ran;
    /** @param head The linked list's head. Note that the head is guanranteed to be not null, 
    so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        ran = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        ListNode res = head;
        for(int n=1; cur!= null; n++) {
            if(ran.nextInt(n) == 0) {
                res = cur;
            }
            cur = cur.next;
        }
        return res.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
