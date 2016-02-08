/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode List<TreeNode> children;
 *     TreeNode(int x) { val = x; children = new LinkedList<TreeNode>();}
 * }
 */
class TreeCounter {
    TreeNode node;
    int depth;
    TreeCounter(int depth, TreeNode node) {
        this.depth = depth;
        this.node = node;
    }
}

public class Solution {
    private TreeCounter traverseTree(TreeNode root) {
        if (root.children.isEmpty()) {
            return new TreeCounter(1, root);
        }
        int maxDepth = Integer.MIN_VALUE;
        TreeCounter temp = new TreeCounter(maxDepth, root);
        int count = 0;
        for (TreeNode child : root.children) {
            TreeCounter tempChild = traverseTree(child);
            if (tempChild.depth > maxDepth) {
                // First time
                maxDepth = tempChild.depth;
                temp.node = (maxDepth == 1) ? root : tempChild.node;
                temp.depth = maxDepth + 1;
            }
            else if (tempChild.depth == maxDepth) {
                // Second time
                temp.node = root;
            }
        }
        return temp;
    }

    public TreeNode deepestNodeCommonAncestor(TreeNode root) {
        if (root == null || root.children.isEmpty()) {
            return root;
        }
        return findAncestor(root).node;
    }
}