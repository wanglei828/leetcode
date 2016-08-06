/*
Given a binary tree, and a node, find all the k-distance nodes.
*/

class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int v) {
		val = v;
	}
}

public class Solution {
	public static List<Integer> find(TreeNode root, TreeNode p, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null || p == null)
			return res;
		subfind(p, k, res);
		TreeNode parent = findParent(root, p);
		while (parent != null && k != 0) {
			k--;
			if(k == 0) {
				res.add(parent.val);
				break;
			} else {
				if (parent.left == p) {
					subfind(parent.right, k-1, res);
				} else {
					subfind(parent.left, k-1, res);
				}
			}
			p = parent;
			parent = findParent(root, p);
		}
		return res;
	}

	private static void subfind(TreeNode root, int k, List<Integer> res) {
		if (root == null)
			return;
		if (k == 0) {
			res.add(root.val);
			return;
		}
		subfind(root.left, k-1, res);
		subfind(root.right, k-1, res);
	}

	private static TreeNode findParent(TreeNode root, TreeNode p) {
		if (root == null || p == root)
			return null;
		if (root.left == p || root.right == p) {
			return root;
		}
		TreeNode next = findParent(root.left, p);
		return (next == null) ? findParent(root.right, p) : next;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(5);
		root.left = n1;
		root.right = n2;
		n2.left = n3;
		n2.right = n4;
		System.out.println(find(root, n1, 3));
	}
}
