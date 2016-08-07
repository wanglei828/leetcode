class TreeNode {
	int val;
	TreeNode left, right;
	public TreeNode(int v) {
		val = v;
	}
}

public class Solution {
	
	int max = 0;
	public int getWidth(TreeNode root) {
		if(root == null) return 0;
		int depth = getDepth(root);
		int[] cnt = new int[depth];
		getLevelWidth(root, 0, cnt);
		return max;
	}
	
	private void getLevelWidth(TreeNode root, int level, int[] cnt) {
		if(root == null) return;
		cnt[level]++;
		max = Math.max(max, cnt[level]);
		getLevelWidth(root.left, level+1, cnt);
		getLevelWidth(root.right,level+1, cnt);
	}
	
	public int getDepth(TreeNode root) {
		if(root == null) return 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		return Math.max(right, left)+1;
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n6;
		System.out.println(so.getWidth(n1));
	}
}
