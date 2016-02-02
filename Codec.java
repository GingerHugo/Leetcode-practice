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

    private void innerSerl(StringBuilder result, TreeNode root) {
        if (root == null) result.append("*");
        else {
            result.append(root.val);
            result.append(",");
            innerSerl(result, root.left);
            result.append(",");
            innerSerl(result, root.right);
        }
    }

    private int innerDesrl(String[] elements, TreeNode root, int start) {
        if (elements[start].equals("*")) return -1;
        else {
            root.val = (Integer.valueOf(elements[start]));
            // Not getInteger, attention!
            // String to Int: Integer.valueOf/parseInt
            // Int to String: Integer.toString
            TreeNode node = new TreeNode(0);
            int startNew = innerDesrl(elements, node, start + 1);
            if (startNew != -1) {
                root.left = node;
                start = startNew + 1;
            }
            else start += 2;
            node = new TreeNode(0);
            startNew = innerDesrl(elements, node, start);
            if (startNew != -1) {
                root.right = node;
                return startNew;
            }
            return start;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "*";
        StringBuilder result = new StringBuilder();
        innerSerl(result, root);
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] elements = data.split(",");
        if (elements[0].equals("*")) return null;
        else {
            TreeNode root = new TreeNode(0);
            innerDesrl(elements, root, 0);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));