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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean nullBw = false;
        while(!q.isEmpty()){
            int s = q.size();
            for(int x = 0; x<s; x++){
                TreeNode curr = q.poll();
                if(curr == null) nullBw = true;
                else {
                    if(nullBw) return false;
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
        }
        return true;
    }
}