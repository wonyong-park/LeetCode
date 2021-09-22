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
        if(root == null) return new ArrayList<>();


        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        helper(result,q);

        return result;
    }

    private void helper(List<List<Integer>> result, Queue<TreeNode> q) {

        if(q.size() == 0) return;

        List<Integer> tempList = new ArrayList<>();
        Queue<TreeNode> tempQ = new LinkedList<>();
        while (!q.isEmpty()) {
            TreeNode now = q.poll();
            tempList.add(now.val);

            if (now.left != null) {
                tempQ.add(now.left);
            }

            if (now.right != null) {
                tempQ.add(now.right);
            }
        }

        result.add(tempList);
        helper(result,tempQ);
    }

}