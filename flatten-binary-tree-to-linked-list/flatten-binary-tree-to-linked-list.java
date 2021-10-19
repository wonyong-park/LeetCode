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
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        //왼쪽 자식이 있는 경우
        //오른쪽 자식으로 바꾸고, 왼쪽자식의 가장 오른쪽 자식을 이전의 오른쪽 자식을 자식으로 갖게한다.
        if (root.left != null) {
            TreeNode preRight = root.right;
            TreeNode preLeft = root.left;
            TreeNode lastNode = getLastNode(preLeft);

            root.right = preLeft;
            root.left = null;
            lastNode.right = preRight;
        }

        flatten(root.right);

    }

    private TreeNode getLastNode(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }

        return root;
    }
}