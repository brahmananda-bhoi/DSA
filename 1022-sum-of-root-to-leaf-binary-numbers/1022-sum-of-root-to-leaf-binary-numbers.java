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
    int sum=0;
    private void helper(TreeNode root, int s){
        if(root==null)
            return;
        s=s<<1;
        s+=root.val;
        if(root.left==null && root.right==null){
            sum+=s;
            return;
        }
        helper(root.left, s);
        helper(root.right, s);
    }
    public int sumRootToLeaf(TreeNode root) {
        sum=0;
        helper(root,0);
        return sum;
    }
}