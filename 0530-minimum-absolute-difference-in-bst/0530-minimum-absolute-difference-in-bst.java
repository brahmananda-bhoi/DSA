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
    int diff=Integer.MAX_VALUE;
    int prev=-1;
    private void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        if (prev != -1)
            diff = Math.min(diff, root.val - prev);
        prev = root.val;
        helper(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return diff;
    }
}