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
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helper(TreeNode root) {
        //null인경우
        if(root == null) return new int[2];

        // 0-> 루트의 값을 포함했을때, 1-> 루트의 값을 포함하지 않았을때
        int[] result = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        //현재노드에서 루트노드의 값을 포함하면 자식의 루트값은 포함할 수 없음
        result[0] = root.val + left[1] + right[1];
        //루트노드의 값을 포함하지 않으면 자식의 루트값을 포함하는 경우와 포함하지 않은 경우 둘다가능
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0],right[1]);
        
        return result;        
    }
}