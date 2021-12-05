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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        //중간에 꺽여서 더 길어질수도 있으니
        int leftDepth = diameterOfBinaryTree(root.left);
        int rightDepth = diameterOfBinaryTree(root.right);
        //root 기준 : getDepth(root.left) + getDepth(root.right) + 2
        int rootDepth = getDepth(root.left) + getDepth(root.right) + 2;

        return Math.max(rootDepth,Math.max(leftDepth, rightDepth));
    }

    public int getDepth(TreeNode root){
        if(root == null) return -1;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return Math.max(leftDepth,rightDepth) + 1;
    }
}