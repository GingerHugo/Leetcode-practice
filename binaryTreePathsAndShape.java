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
    private void traverseTree(LinkedList<Integer> nodes, TreeNode root, LinkedList<Integer> width, Integer w) {
        nodes.add(root.val);
        width.add(w);
        if (root.left == null && root.right == null) {
            int widMin = w;
            for (int i : width) {
                widMin = Math.min(widMin, i);
            }
            
            for (int i = 0; i < nodes.size(); i++) {
                int temp = width.get(i);
                if (temp > widMin) {
                    temp -= widMin;
                    System.out.print(String.format("%"+temp+"s", ""));
                }
                String.out.println(nodes.get(i));
            }
            
        }
        else {
            if (root.left != null) {
                traverseTree(nodes, root.left, width, w - 1);
            }
            if (root.right != null) {
                traverseTree(nodes, root.right, width, w + 1);
            }
        }
        nodes.removeLast();
        width.removeLast();
    }

    public List<String> binaryTreePathsAndShape(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Integer> width = new LinkedList<>();
        LinkedList<Integer> nodes = new LinkedList<>();
        traverseTree(nodes, root, width, 0);
    }
}