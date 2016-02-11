public class NumArray {
    class segmentTreeNode {
        int val;
        int start;
        int end;
        segmentTreeNode left, right;
        public segmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }
    }

    private segmentTreeNode root = null;

    private segmentTreeNode buildTree(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        segmentTreeNode temp = new segmentTreeNode(start, end);
        if (start == end) {
            temp.val = nums[start];
        }
        else {
            int mid = start + (end - start) / 2;
            temp.left = buildTree(start, mid, nums);
            temp.right = buildTree(mid + 1, end, nums);
            temp.val = temp.left.val + temp.right.val;
        }
        return temp;
    }

    private void updateTree(segmentTreeNode root, int index, int value) {
        if (root.start == root.end) {
            root.val = value;
        }
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (index <= mid) {
                updateTree(root.left, index, value);
            }
            else {
                updateTree(root.right, index, value);
            }
            root.val = root.left.val + root.right.val;
        }
    }

    private int sumTree(segmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.val;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (j <= mid) {
            return sumTree(root.left, i, j);
        }
        else if (i > mid) {
            return sumTree(root.right, i, j);
        }
        else {
            return sumTree(root.left, i, mid) + sumTree(root.right, mid + 1, j);
        }
    }

    public NumArray(int[] nums) {
        root = buildTree(0, nums.length - 1, nums);
    }

    void update(int i, int val) {
        updateTree(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumTree(root, i, j);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);