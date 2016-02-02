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
    private void processNode(TreeNode root, int num, TreeMap<Integer, List<Integer>> table) {
        if (root == null) return;
        if (table.containsKey(num)) table.get(num).add(root.val);
        else {
            List<Integer> temp = new LinkedList<Integer>();
            temp.add(root.val);
            table.put(num, temp);
        }
    }

    private void traverseTree(TreeNode root, int num, TreeMap<Integer, List<Integer>> table) {
        processNode(root.left, num - 1, table);
        processNode(root.right, num + 1, table);
        if (root.left != null) traverseTree(root.left, num - 1, table);
        if (root.right != null) traverseTree(root.right, num + 1, table);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> table = new TreeMap<>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        processNode(root, 0, table);
        traverseTree(root, 0, table);
        for (Map.Entry<Integer, List<Integer>> element : table.entrySet())
            result.add(element.getValue());
        return result;
    }
}