/*
Given an integer n, return a list of all possible full binary trees with n nodes. 
Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.

 

Example 1:


Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
Example 2:

Input: n = 3
Output: [[0,0,0]]
 

Constraints:

1 <= n <= 20
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
    unordered_map<int, vector<TreeNode*>> map;
    vector<TreeNode*> allPossibleFBT(int n) {
        if (map.find(n) != map.end()) {
            return map[n];
        }
        vector<TreeNode*> res;
        if (n == 0) {
            map[0] = res;
            return res;
        }
        if (n == 1) {
            res.push_back(new TreeNode(0));
            map[1] = res;
            return res;
        }
        for (int i = 1; i <= n-1; i++) {
            vector<TreeNode*> left = allPossibleFBT(i);
            vector<TreeNode*> right = allPossibleFBT(n-1-i);
            if (left.size() == 0 || right.size() == 0) {
                continue;
            }           
            for (TreeNode* l : left) {
                for (TreeNode* r : right) {
                    TreeNode* root = new TreeNode(0);
                    root->left = l;
                    root->right = r;
                    res.push_back(root);
                }
            }
        }
        map[n] = res;
        return res;
    }
};
