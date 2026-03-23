/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        // Start zigzag going left from root
        dfs(root, true, 0);
        // Start zigzag going right from root
        dfs(root, false, 0);
        return maxLength;
    }
    // goLeft: should we go left to continue zigzag?
    // length: current zigzag length
    private void dfs(TreeNode node, boolean goLeft, int length) {
        if (node == null) return;
        maxLength = Math.max(maxLength, length);
        if (goLeft) {
            dfs(node.left, false, length + 1);  // continue zigzag: go left, next go right
            dfs(node.right, true, 1);           // restart zigzag: go right, next go left
        }
        else {
            dfs(node.right, true, length + 1);  // continue zigzag: go right, next go left
            dfs(node.left, false, 1);           // restart zigzag: go left, next go right
        }
    }
}