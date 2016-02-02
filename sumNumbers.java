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
    private void TraverseTree(TreeNode root, int number , List<Integer> numbers) {
        number = number * 10 + root.val;
        if (root.left != null) {
            TraverseTree (root.left, number, numbers);
        }
        if (root.right != null) {
            TraverseTree (root.right, number, numbers);
        }
        if (root.left == null && root.right == null) {
            numbers.add(number);
        }
    }
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> numbers = new LinkedList<>();
        TraverseTree(root, 0, numbers);
        int result = 0;
        for (int i : numbers) {
            result += i;
        }
        return result;
    }
}