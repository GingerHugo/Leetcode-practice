/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode List<TreeNode> children;
 *     TreeNode(int x) { val = x; children = new LinkedList<TreeNode>();}
 * }
 */
public class Solution {
    private int traverseTree(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int temp = depth + 1;
        for (TreeNode child : root.children) {
            temp = Math.max(traverseTree(child, depth + 1), temp);
        }
        return temp;
    }

    private TreeNode findAncestor(TreeNode root, int curDepth, int depth) {
        if (root == null || curDepth == depth) return root;
        int count = 0;
        for (TreeNode child : root.children) {
            TreeNode tempNode = findAncestor(child, curDepth + 1, depth);
            if (tempNode != null) {
                count++;
            }
        }
        if (count == 1) {
            return tempNode;
        }
        else if (count == 0) {
            return null;
        }
        else {
            return root;
        }
    }

    public TreeNode deepestNodeCommonAncestor(TreeNode root) {
        int depth = traverseTree(root, 0);
        return findAncestor(root, 1, depth);   
    }
}