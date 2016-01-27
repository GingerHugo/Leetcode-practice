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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> table = new HashSet<>();
        stack.push(root);
        LinkedList<Integer> values = new LinkedList<>();
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (!table.contains(temp)) {
                table.add(temp);
                if (temp.left == null && temp.right == null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < values.size(); i++) {
                        sb.append(values.get(i));
                        sb.append("->");
                    }
                    sb.append(temp.val);
                    result.add(sb.toString());
                }
                else {
                    stack.push(temp);
                    values.add(temp.val);
                }
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }
            else {
                values.removeLast();
            }
        }
        return result;
    }
}