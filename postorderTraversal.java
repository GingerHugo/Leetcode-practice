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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> candidate = new LinkedList<>();
        Set<TreeNode> selectSet = new HashSet<>(); 
        candidate.add(root);
        while(!candidate.isEmpty()) {
            TreeNode node = candidate.get(0);
            if ((selectSet.contains(node)) || (node.left == null && node.right == null)) {
                result.add(node.val);
                candidate.remove(0);
            }
            else {
                if (node.right != null) {
                    candidate.add(0, node.right);
                }
                if (node.left != null) {
                    candidate.add(0, node.left);
                }
                selectSet.add(node);
            }
        }
        return result;
    }
}