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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        res.add(root.val);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        helper(res, q);
        return res;
    }

    private void helper(List<Integer> res, Queue<TreeNode> q) {

        if(q.size() == 0) return;

        Queue<TreeNode> tempQ = new LinkedList<>();

        while (!q.isEmpty()) {
            TreeNode now = q.poll();

            if (now.right != null) {
                tempQ.offer(now.right);
            }

            if (now.left != null) {
                tempQ.offer(now.left);
            }
        }

        if (!tempQ.isEmpty()) {
            res.add(tempQ.peek().val);
        }

        helper(res, tempQ);

    }
}