/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private void traverseTree(List<String> result, TreeNode root, String pre) {
        if (root.left == null && root.right == null) {
            result.add(pre + root.val); // Integer.toString(root.val); directly add is also OK
        }
        if (root.left != null) {
            traverseTree(result, root.left, pre + root.val + "->");
        }
        if (root.right != null) {
            traverseTree(result, root.right, pre + root.val + "->");
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        traverseTree(result, root, "");
        return result;
    }
}