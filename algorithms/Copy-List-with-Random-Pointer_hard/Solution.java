/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = null;
        RandomListNode cur = head;
        while(cur != null) {
            if(!map.containsKey(cur)) {
                RandomListNode copy = new RandomListNode(cur.label);
                map.put(cur, copy);
                if(newHead == null) {
                    newHead = copy;
                }
            }
            if(cur.next != null) {
                if(!map.containsKey(cur.next)) {
                    RandomListNode copy = new RandomListNode(cur.next.label);
                    map.put(cur.next, copy);
                    map.get(cur).next = copy;
                } else {
                    map.get(cur).next = map.get(cur.next);
                }
            }
            if(cur.random != null) {
                if(!map.containsKey(cur.random)) {
                    RandomListNode copy = new RandomListNode(cur.random.label);
                    map.put(cur.random, copy);
                    map.get(cur).random = copy;
                } else {
                    map.get(cur).random = map.get(cur.random);
                }
            }
            cur = cur.next;
        }
        return newHead;
    }
}
