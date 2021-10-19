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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (inorder.length == 0 || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        //inorder의 root index찾기
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, index+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] leftSubInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightSubInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        root.left = buildTree(leftPreorder, leftSubInorder);
        root.right = buildTree(rightPreorder, rightSubInorder);

        return root;
    }
}