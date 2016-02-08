import java.io.*;
import java.util.*;

class TreeNode {
    int val;
    ArrayList<TreeNode> children;
    TreeNode(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}

class TreeNodeWrapper {
    TreeNode node;
    int maxDepth;
    TreeNodeWrapper(TreeNode node, int maxDepth) {
        this.node = node;
        this.maxDepth = maxDepth;
    }
}

class Solution {
    public TreeNode find(TreeNode root) {
        if (root == null || root.children.isEmpty()) {
            return root;
        }
        return helper(root).node;
    }
    
    public TreeNodeWrapper helper(TreeNode root) {
        if (root.children.isEmpty()) {
            return new TreeNodeWrapper(root, 1);
        }
        
        int maxDepth = Integer.MIN_VALUE;
        int size = root.children.size();
        TreeNodeWrapper r = new TreeNodeWrapper(root, maxDepth);
        
        for (int i = 0; i < size; i++) {
            TreeNodeWrapper wrapper = helper(root.children.get(i));
            if (wrapper.maxDepth > maxDepth) {
                maxDepth = wrapper.maxDepth;
                r.node = (maxDepth == 1? root: wrapper.node);
                r.maxDepth = wrapper.maxDepth + 1;
            } else if (wrapper.maxDepth == maxDepth) {
                r.node = root;
            }        
        }
        return r;
    }
}