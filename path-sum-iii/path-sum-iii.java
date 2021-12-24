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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return search(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int search(TreeNode root, int targetSum) {
        if(root == null) return 0 ;
        
        int count = 0;
        if(root.val == targetSum) count++;
        count += search(root.left, targetSum - root.val);
        count += search(root.right, targetSum - root.val);
        
        return count;
    }

}