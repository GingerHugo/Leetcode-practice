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
    private TreeNode traverseTree (int leftIndex, int rightIndex, int[] nums) {
        int midIndex = (leftIndex + rightIndex) / 2;
        TreeNode resultTree = new TreeNode(0);
        resultTree.val = nums[midIndex];
        if (leftIndex < midIndex) {
            resultTree.left = traverseTree(leftIndex, midIndex, nums);
        }
        if ((midIndex + 1) < rightIndex) {
            resultTree.right = traverseTree(midIndex + 1, rightIndex, nums);
        }
        return resultTree;
    }
    public TreeNode sortedArrayToBST(int[] nums) {    
        if (nums.length == 0) {
            return null;
        }
        else if (nums.length == 1) {
            TreeNode resultTree = new TreeNode(nums[0]);
            return resultTree;  
        }
        else {
            return traverseTree(0, nums.length, nums);
        }
    }
}