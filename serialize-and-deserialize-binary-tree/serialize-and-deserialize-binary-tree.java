/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        String result = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur != null){
                result += cur.val + "#";
            }else{
                result += "null#";
                continue;
            }
            q.offer(cur.left);
            q.offer(cur.right);
        }

        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "" || data.equals("")) return null;
        String[] split = data.split("#");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        q.add(root);
        
        for (int i = 1; i < split.length; i++) {
            //부모의 왼쪽자식하고 오른쪽 자식이 null이 아닐때 자식처리
            TreeNode parent = q.poll();
            
            //왼쪽자식이 null이 아닌 경우
            if (!(split[i] == "null" || split[i].equals("null"))) {
                TreeNode left = new TreeNode(Integer.parseInt(split[i]));
                parent.left = left;
                q.add(left);
            }
            
            i++;
            if (!(split[i] == "null" || split[i].equals("null"))) {
                TreeNode right = new TreeNode(Integer.parseInt(split[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));