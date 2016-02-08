/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNodeCounter {
    TreeNode node;
    int hit;
    TreeNodeCounter(TreeNode node, int hit) {
        this.node = node;
        this.hit = hit;
    }
}

public class Solution {
    private TreeNodeCounter traverseTree(TreeNode root, TreeNode p, TreeNode q) {
        TreeNodeCounter c = new TreeNodeCounter(root, 0);
        if (root == p || root == q) {
            c.hit = 1;
        }
        if (root == null || root.left == null && root.right == null) {
            return c;
        }
        TreeNodeCounter left = traverseTree(root.left, p, q);
        TreeNodeCounter right = traverseTree(root.right, p, q);
        
        if (left.hit != 0 && right.hit != 0) {
            c.hit = 2;
        }
        else if (left.hit != 0 && c.hit == 0) {
            c.hit = 1;
            c.node = left.node;
        }
        else if (right.hit != 0 && c.hit == 0) {
            c.hit = 1;
            c.node = right.node;
        }
        return c;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        return traverseTree(root, p, q).node;
    }
}