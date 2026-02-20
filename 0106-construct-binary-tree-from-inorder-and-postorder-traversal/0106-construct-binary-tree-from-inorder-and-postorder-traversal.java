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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        TreeNode root = buildTree(postorder, postorder.length - 1, 0, inorder, 0, inorder.length - 1, inMap);
        return root;
    }
    public TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> inMap) {
        if (postStart < postEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        int inRoot = inMap.get(root.val);
        int numsRight = inEnd - inRoot;
        root.right = buildTree(postorder, postStart - 1, postStart - numsRight, inorder, inRoot + 1, inEnd, inMap);
        root.left = buildTree(postorder, postStart - numsRight - 1, postEnd, inorder, inStart, inRoot - 1, inMap);
        return root;
    }
}