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
    private void dfs(TreeNode root, int level, List<Integer> ans){
        if(root == null)
            return;
        if(level < ans.size()){
            int max = Math.max(ans.get(level), root.val);
            ans.set(level, max);
        }
        else
            ans.add(root.val);
        dfs(root.left, level+1, ans);
        dfs(root.right, level+1, ans);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }
}


// class Solution {
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         if(root == null)
//             return ans;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             int max = Integer.MIN_VALUE;
//             for(int i=0; i< size; i++){
//                 TreeNode cur = q.poll();
//                 max = Math.max(max, cur.val);
//                 if(cur.left != null)
//                     q.offer(cur.left);
//                 if(cur.right != null)
//                     q.offer(cur.right);
//             }
//             ans.add(max);
//         }
//         return ans;
//     }
// }