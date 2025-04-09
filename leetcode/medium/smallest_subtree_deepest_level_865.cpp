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
        pair<int, TreeNode*> traverse(TreeNode* root, int depth) {
            if (root == nullptr) {
                return {0, root};
            }
            auto left = traverse(root->left, depth + 1);
            auto right = traverse(root->right, depth + 1);
            if (left.first > right.first) {
                return {left.first + 1, left.second};
            } else if (right.first > left.first) {
                return {right.first + 1, right.second};
            } else {
                return {left.first + 1, root};
            }
        }
        TreeNode* subtreeWithAllDeepest(TreeNode* root) {
            if(root == nullptr) return root;
            auto result = traverse(root, 0);
            return result.second;
        }
    };