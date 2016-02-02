/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private Stack<TreeNode> store = new Stack<>();
    private void pushTree(TreeNode root) {
        while (root != null) {
            store.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        pushTree(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !store.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = store.pop();
        pushTree(temp.right);
        return temp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */