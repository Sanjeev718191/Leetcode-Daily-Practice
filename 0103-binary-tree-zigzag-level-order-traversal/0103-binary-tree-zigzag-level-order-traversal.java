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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.offerLast(root);
        int level = 1;
        while(!st.isEmpty()){
            ls.add(new ArrayList<>());
            int s = st.size();
            Deque<TreeNode> temp = new ArrayDeque<>();
            for(int i = 0; i<s; i++){
                if(level%2 == 1){
                    TreeNode curr = st.removeFirst();
                    ls.get(level-1).add(curr.val);
                    if(curr.left != null) temp.offerLast(curr.left);
                    if(curr.right != null) temp.offerLast(curr.right);
                } else {
                    TreeNode curr = st.removeLast();
                    ls.get(level-1).add(curr.val);
                    if(curr.right != null) temp.offerFirst(curr.right);
                    if(curr.left != null) temp.offerFirst(curr.left);
                }
            }
            level++;
            st = temp;
        }
        return ls;
    }
}