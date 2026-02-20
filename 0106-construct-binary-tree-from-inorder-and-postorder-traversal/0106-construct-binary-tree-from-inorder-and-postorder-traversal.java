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
    private int postIndex;     // tracks current root in postorder (from right to left)
    private Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        // Build value → index map for O(1) lookup in inorder
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);
        // Start from the end of postorder (root is always last)
        postIndex = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd) {
        // Base case: no elements in this subtree
        if (inStart > inEnd)
            return null;
        // Current root value (take from postorder and move left)
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        // Find position of current root in inorder array
        int rootInorderIdx = inorderIndexMap.get(rootVal);
        // Right subtree comes before root in postorder → build right first
        root.right = build(inorder, postorder, rootInorderIdx + 1, inEnd);
        // Left subtree comes after right subtree in postorder
        root.left  = build(inorder, postorder, inStart, rootInorderIdx - 1);
        return root;
    }
}