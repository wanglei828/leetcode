/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
*/

public class NumArray {
    class SegtreeNode {
        int s;
        int e;
        int sum;
        SegtreeNode left, right;
        public SegtreeNode(int s, int e) {
            this.s = s;
            this.e = e;
            this.sum = 0;
            left = null;
            right = null;
        }
    }
    
    private SegtreeNode root;
    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0) return;
        root = buildTree(nums, 0, nums.length-1);
    }
    
    private SegtreeNode buildTree(int[] nums, int h, int t) {
        SegtreeNode node = new SegtreeNode(h, t);
        if(h == t) {
            node.sum = nums[h];
            return node;
        }
        int m = h+(t-h)/2;
        SegtreeNode left = buildTree(nums, h, m);
        SegtreeNode right = buildTree(nums, m+1, t);
        node.sum = left.sum + right.sum;
        node.right = right;
        node.left = left;
        return node;
    }

    void update(int i, int val) {
        updateHelp(root, i, val);
    }
    
    private void updateHelp(SegtreeNode node, int i, int val) {
        if(node == null || i<node.s || i>node.e) return;
        if(i == node.s && i == node.e) {
            node.sum = val;
            return;
        }
        updateHelp(node.left, i, val);
        updateHelp(node.right, i, val);
        int left = (node.left == null)? 0 : node.left.sum;
        int right = (node.right == null)? 0 : node.right.sum;
        node.sum = left + right;
    }

    public int sumRange(int i, int j) {
        return sumHelp(root, i, j);
    }
    
    private int sumHelp(SegtreeNode node, int i, int j) {
        if(node == null || node.s > j || node.e < i ||  i > j) return 0;
        if(i <= node.s && j >= node.e) return node.sum;
        int m = node.s + (node.e - node.s)/2;
        int left = sumHelp(node.left, i, Math.min(m, j));
        int right = sumHelp(node.right, Math.max(m+1, i), j);
        return left + right;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
