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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null) return ans;
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            ArrayList<Integer> level = new ArrayList<>();

            for(int i =0 ; i<size; i++){
                TreeNode node = que.poll(); 
                level.add(node.val);
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
}