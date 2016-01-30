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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> candidate = new LinkedList<>();
        candidate.add(root);
        while(!candidate.isEmpty()) {
            TreeNode node = candidate.get(0);
            candidate.remove(0);
            result.add(node.val);
            if (node.right != null) {
                candidate.add(0, node.right);
            }
            if (node.left != null) {
                candidate.add(0, node.left);
            }
            
        }
        return result;
    }
}