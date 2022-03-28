/*

Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

 

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
 

Note:

1 <= pre.length == post.length <= 30
pre[] and post[] are both permutations of 1, 2, ..., pre.length.
It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre == null || pre.length == 0) return null;
        return buildTree(pre, 0, pre.length-1, post, 0, post.length-1);
    }
    
    private TreeNode buildTree(int[] pre, int preH, int preT, int[] post, int postH, int postT) {
        if(postH > postT) return null;
        if(postH == postT) {
            return new TreeNode(post[postT]);
        }
        TreeNode root = new TreeNode(post[postT]);
        int preIndex = preH;
        for(int i=preH; i<=preT; i++) {
            if(pre[i] == post[postT-1]) {
                preIndex = i;
                break;
            }
        }
        int postIndex = postH;
        for(int i=postH; i<=postT; i++) {
            if(post[i] == pre[preH+1]) {
                postIndex = i;
                break;
            }
        }
        root.right = buildTree(pre, preIndex, preT, post, postIndex+1, postT-1);
        root.left = buildTree(pre, preH+1, preIndex-1, post, postH, postIndex);
        return root;
    }
}
