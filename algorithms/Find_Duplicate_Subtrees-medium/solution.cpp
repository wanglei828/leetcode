/*
Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.
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
    unordered_map<string, int> map;
    vector<TreeNode*> res;
public:
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        traverse(root);
        return res;
    }
    
    string traverse(TreeNode* root) {
        if (root == nullptr) return "null";
        string left = traverse(root->left);
        string right = traverse(root->right);
        string val = to_string(root->val);
        string tree = "(" + left + ")" + val + "(" + right + ")";
        map[tree]++;
        if (map[tree] == 2) {
            res.push_back(root);
        }
        return tree;
    }
};
