public class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        int n = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == n - mid) {
                return citations[mid];
            }
            else if (citations[mid] > n - mid) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}