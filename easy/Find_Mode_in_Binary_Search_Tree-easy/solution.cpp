/*
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> findMode(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> st;
        TreeNode* prev = nullptr;
        int cnt = 0;
        int maxcnt = INT_MIN;
        while (!st.empty() || root != nullptr) {
            if (root != nullptr) {
                st.push(root);
                root = root->left;
            } else {
                root = st.top();
                st.pop();
                if (prev != nullptr && prev->val == root->val) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (cnt > maxcnt) {
                    maxcnt = cnt;
                    res.clear();
                    res.push_back(root->val);
                } else if (cnt == maxcnt) {
                    res.push_back(root->val);
                }
                prev = root;
                root = root->right;
            }
        }
        return res;
    }
};
