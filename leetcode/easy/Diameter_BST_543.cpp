/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
 class Solution {
    public:
        int maxPath = INT_MIN;
        int traverse(TreeNode* root) {
            if (root == nullptr)
                return 0;
            int left = 0, right = 0;
            if (root->left != nullptr)
                left = 1 + traverse(root->left);
            if (root->right != nullptr)
                right = 1 + traverse(root->right);
            int val = left + right;
            maxPath = max(maxPath, val);
            return max(left, right);
        }
        int diameterOfBinaryTree(TreeNode* root) {
            if (root == nullptr)
                return 0;
            traverse(root);
            return maxPath;
        }
    };