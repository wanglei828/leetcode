/*
Given a Circular Linked List node, which is sorted in ascending order, 
write a function to insert a value insertVal into the list such that it remains a sorted circular list. 
The given node can be a reference to any single node in the list and may not necessarily be the smallest value in the circular list.

If there are multiple suitable places for insertion, 
you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.

If the list is empty (i.e., the given node is null), 
you should create a new single circular list and return the reference to that single node. 
Otherwise, you should return the originally given node.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node pre = head;
        Node cur = pre.next;
        boolean canInsert = false;
        do {
            if (insertVal >= pre.val && insertVal <= cur.val) {
                canInsert = true;
            } else if (pre.val > cur.val) {
                if (insertVal >= pre.val || insertVal <= cur.val) {
                    canInsert = true;
                }
            }
            if (canInsert) {
                pre.next = new Node(insertVal, cur);
                return head;
            }
            pre = cur;
            cur = cur.next;
        } while(pre != head);
        
        pre.next = new Node(insertVal, cur);
        return head;
    }
}
