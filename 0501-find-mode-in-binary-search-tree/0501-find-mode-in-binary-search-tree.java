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
    public int[] findMode(TreeNode root) {
        int max=0;
        List<Integer> li = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                int freq = map.getOrDefault(cur.val, 0)+1;
                max = Math.max(max, freq);
                map.put(cur.val, freq);
                if(cur.left != null)
                    q.offer(cur.left);
                if(cur.right != null)
                    q.offer(cur.right);

            }
        }
        for(int key : map.keySet()){
            if(map.get(key) == max)
                li.add(key);
        }
        int[] ans = new int[li.size()];
        for(int i=0; i<li.size(); i++)
            ans[i] = li.get(i);
        return ans;
    }
}