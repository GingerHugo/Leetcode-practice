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
    // DFS Version
    private void traverseTree (TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new LinkedList<>());
        }
        if (level % 2 == 0) {
            result.get(level).add(node.val);
        }
        else {
            result.get(level).add(0, node.val);
        }
        traverseTree(node.left, level + 1, result);
        traverseTree(node.right, level + 1, result);
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traverseTree(root, 0, result);
        return result;
    }
}