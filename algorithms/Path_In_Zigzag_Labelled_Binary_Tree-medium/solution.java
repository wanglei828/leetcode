/*
In an infinite binary tree where every node has two children, the nodes are labelled in row order.

In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, 
while in the even numbered rows (second, fourth, sixth,...), 
the labelling is right to left.

Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.

 

Example 1:

Input: label = 14
Output: [1,3,4,14]
Example 2:

Input: label = 26
Output: [1,2,6,10,26]
*/

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int level = (int)(Math.log(label) / Math.log(2));
        LinkedList<Integer> res = new LinkedList<>();
        while(level >= 0) {
            res.addFirst(label);
            int min = 1 << level;
            int max = (1 << (level+1)) - 1;
            if (level % 2 == 0) {
                label = (max - (label - min)) / 2;
            } else {
                label = (min + (max - label)) / 2;
            }        
            level--;
        }
        return res;
    }
}
