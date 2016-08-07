/*
Delete node in a binary search tree
*/

class TreeNode {
  int val;
  TreeNode left, right;
  public TreeNode(int val) {
    this.val = val;
  }
}

public class Solution {
  public TreeNode DeleteNode(TreeNode root, int key) {
    if(root == null) return null;
    if(key < root.val) {
      root.left = DeleteNode(root.left, key);
    } else if(key > root.val) {
      root.right = DeleteNode(root.right, key);
    } else {
      if(root.left == null) {
        return root.right;
      } else if(root.right == null ) {
        return root.left;
      }
        
      root.key = minValue(root.right);
      root.right = DeleteNode(root.right, root.key);
    }
    return root;
  }
  
  public TreeNode AddNode(TreeNode root, int val) {
    if(root == null) {
      root = new TreeNode(val);
      return root;
    }
    if(val < root.val) {
      root.left = AddNode(root.left, val);
    } else {
      root.right = AddNode(root.right, val);
    }
    return root;
  }

  private int minValue(TreeNode node) {
    int  min = node.val;
    while(node.left != null) {
      min = node.left.val;
      node = node.left;
    }
    return min;
  }
}
