/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            };
        }
        );
        for(int i=0; i<lists.length; i++) {
            if(lists[i] != null) {
                q.add(lists[i]);
            }
        }
        ListNode res = new ListNode(0);
        ListNode cur = null;
        ListNode pre = res;
        while(!q.isEmpty()) {
            cur = q.poll();
            pre.next = cur;
            pre = cur;
            if(cur.next != null) {
                q.add(cur.next);
            }
        }
        return res.next;
    }
}
