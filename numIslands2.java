public class Solution {
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        List<Integer> result = new LinkedList<>();
        UnionFind2D union = new UnionFind2D(n, m);
        for (int[] pair : positions) {
            int x = pair[0], y = pair[1];
            int p = union.add(x, y);
            if (x > 0) {
                int q = union.getIndex(x - 1, y);
                union.uniteTwo(p, q);
            }
            if (y > 0) {
                int q = union.getIndex(x, y - 1);
                union.uniteTwo(p, q);
            }
            if (x < n - 1) {
                int q = union.getIndex(x + 1, y);
                union.uniteTwo(p, q);
            }
            if (y < m - 1) {
                int q = union.getIndex(x, y + 1);
                union.uniteTwo(p, q);
            }
            result.add(union.getSize());
        }
        return result;
    }
}

class UnionFind2D {
    private int n, m, count;
    private int[] weight;
    private int[] upper;

    public UnionFind2D(int n, int m) {
        this.n = n;
        this.m = m;
        this.weight = new int[n * m + 1]; // Must consider 0 case
        this.upper = new int[n * m + 1];
    }

    public int getIndex(int i, int j) {
        // return i * n + m + 1; // Wrong here!
        return i * m + j + 1;
    }

    public int add(int x, int y) {
        int index = getIndex(x, y);
        weight[index] = 1;
        upper[index] = index;
        count++;
        return index;
    }

    public int getSize() {
        return count;
    }

    public void uniteTwo(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j || i == 0 || j == 0) {
            return;
        }
        if (weight[i] > weight[j]) {
            upper[j] = i;
            weight[i] += weight[j];
        }
        else {
            upper[i] = j;
            weight[j] += weight[i];
        }
        count--;
    }

    private int root(int i) {
        for (; i != upper[i]; i = upper[i]) {
            upper[i] = upper[upper[i]];
        }
        return i;
    }

}