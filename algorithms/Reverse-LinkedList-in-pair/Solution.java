/*
1->2->3->4->5->6->7

2->1->4->3->6->5->7
*/

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
    public static ListNode reverse(ListNode head) {
    	if(head == null) return null;
    	ListNode res = new ListNode(0);
    	ListNode pre = res;
    	ListNode p1 = head;
    	ListNode p2 = null;
    	ListNode next = null;
    	while(p1 != null && p1.next != null) {
    		p2 = p1.next;
    		next = p2.next;
    		p2.next = p1;
    		pre.next = p2;
    		pre = p1;
    		p1 = next;
    	}
    	pre.next = p1;
    	return res.next;
    }
}
