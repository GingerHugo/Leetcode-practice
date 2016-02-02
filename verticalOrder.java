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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> table = new TreeMap<>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> tableNum = new HashMap<>();
        if (root == null) return result;
        queue.add(root);
        tableNum.put(root, 0);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                int num = tableNum.get(temp);
                if (table.containsKey(num)) table.get(num).add(temp.val);
                else {
                    List<Integer> tempList = new LinkedList<Integer>();
                    tempList.add(temp.val); table.put(num, tempList);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                    tableNum.put(temp.left, num - 1);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    tableNum.put(temp.right, num + 1);
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> element : table.entrySet())
            result.add(element.getValue());
        return result;
    }
}