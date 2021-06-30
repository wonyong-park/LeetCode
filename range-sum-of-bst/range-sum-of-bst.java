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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode dump = stack.pop();
            
            if(low <= dump.val && dump.val <= high) sum += dump.val;
            
            if(dump.left != null){
                stack.push(dump.left);
            }
        
            if(dump.right != null){
                stack.push(dump.right);
            }
            
        }
        
        return sum;
        
    }
}