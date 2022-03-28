/*

Given a node from a cyclic linked list which is sorted in ascending order, 
write a function to insert a value into the list such that it remains a cyclic sorted list. 
The given node can be a reference to any single node in the list, 
and may not be necessarily the smallest value in the cyclic list.

If there are multiple suitable places for insertion, 
you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.

If the list is empty (i.e., given node is null), 
you should create a new single cyclic list and return the reference to that single node. 
Otherwise, you should return the original given node.

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null) {
            return node;
        }
        Node pre = head;
        Node next = head.next;
        while(next != head) {
            if((insertVal >= pre.val && insertVal <= next.val) || (insertVal > pre.val && pre.val > next.val) || (insertVal < next.val && pre.val > next.val)) {
                
                node.next = next;
                pre.next = node;
                break;
            } else {
                pre = next;
                next = next.next;
            }
        }
        if(next == head) {
            pre.next = node;
            node.next = next;
        }
        return head;
    }
}
