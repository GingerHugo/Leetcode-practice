/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// import java.util.Stack;
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> stackValue = new LinkedList<Integer>();
        LinkedList<List<Integer>> stackList = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> stackChild = new LinkedList<TreeNode>();
        // List<List<Integer>> resultList = new LinkedList<LinkedList<Integer>>();
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        if (root == null)   return resultList;
        stackValue.addFirst(root.val);
        stackChild.addFirst(root);
        List<Integer> listTemp = new LinkedList<>(Arrays.asList(root.val));
        stackList.addFirst(listTemp);
        while (!stackValue.isEmpty()) {
            TreeNode temp = stackChild.removeFirst();
            int sumNum = stackValue.removeFirst();
            List<Integer> listNum = stackList.removeFirst();
            // if (sumNum > sum) continue;//  Negative Number Case!!!
            // if ((sumNum > sum && sum >= 0) || ()) continue;
            if (temp.right != null) {
                stackChild.addFirst(temp.right);
                stackValue.addFirst(temp.right.val + sumNum);
                List<Integer> list1 = new LinkedList<>(listNum);
                list1.add(temp.right.val);
                stackList.addFirst(list1);
            }
            if (temp.left != null)  {
                stackChild.addFirst(temp.left);
                stackValue.addFirst(temp.left.val + sumNum);
                List<Integer> list2 = new LinkedList<>(listNum);
                list2.add(temp.left.val);
                stackList.addFirst(list2);
            }
            else if (temp.right == null) {
                if (sumNum == sum) {
                    resultList.add(listNum);
                }
            }
        }
        return resultList;
    }
}