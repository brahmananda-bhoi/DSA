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
// class Solution {
//     public int findSecondMinimumValue(TreeNode root) {
//         if(root.left == null || root.right == null)
//             return -1;
//         else if(root.left.val == root.right.val)
//             return Math.max(findSecondMinimumValue(root.left), findSecondMinimumValue(root.right));
//         else
//             return Math.max(root.left.val, root.right.val);
//     }
// }





class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        // Root has the minimum value
        return findSecond(root, root.val);
    }
    private int findSecond(TreeNode node, int minVal) {
        if (node == null) return -1;
        // If current node's value is greater than minimum, it's a candidate
        if (node.val > minVal)
            return node.val;
        // Current node equals minVal, so search in both subtrees
        int left = findSecond(node.left, minVal);
        int right = findSecond(node.right, minVal);
        // Combine results
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);  // Return smaller of the two
    }
}
