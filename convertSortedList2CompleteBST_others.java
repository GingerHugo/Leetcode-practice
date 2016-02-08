public class Solution {
    private ListNode node;

    private int getDividePos(int start, int end) {
        int m = end - start + 1;
        if (m < 4) {
            return m / 2 + 1;
        }
        int height = (int)Math.ceil(Math.log(m + 1) / Math.log(2));
        if(3 * Math.pow(2, height - 2) - 1 >= m) {
            return end - (int) Math.pow(2, height - 2) + 1;
        }
        else {
            return start + (int) Math.pow(2, height - 1) - 1;
        }
    }

    private int getLength(ListNode node) {
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public TreeNode convertSortedList2CompleteBST(ListNode head) {
        if(head == null) {
            return null;
        }

        this.node = head;
        int length = getLength(head);
        return convert(0, length - 1);
    }

    private TreeNode convert(int start, int end) {
        // Inorder traversal + sequential go through the linkedlist
        if(start == end) {
            TreeNode root = new TreeNode(node.value);
            node = node.next;
        }
        else {
            int rootIndex = getDividePos(start, end);
            TreeNode left = convert(start, rootIndex - 1);
            TreeNode root = new TreeNode(node.value);
            node = node.next;
            TreeNode right = convert(rootIndex + 1, end);
            root.left = left;
            root.right = right;
        }
        return root;
    }
}