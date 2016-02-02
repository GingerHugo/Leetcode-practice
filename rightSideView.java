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
    private HashSet<Integer> layerRecord = new HashSet<>();
    private void traverseTree(TreeNode parent, List<Integer> resultList, int layer) {
        if (!layerRecord.contains(layer)) {
            layerRecord.add(layer);
            resultList.add(parent.val);
        }
        if (parent.right != null) {
            traverseTree(parent.right, resultList, layer + 1);
        }
        if (parent.left != null) {
            traverseTree(parent.left, resultList, layer + 1);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new LinkedList<>();
        if (root != null) {
            int layer = 0;
            traverseTree(root, resultList, layer);
        }
        return resultList;
    }
}