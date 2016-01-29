public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int left = 0;
        int right = citations.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (citations[mid] == citations.length - mid)
                return citations[mid];
            else if (citations[mid] > citations.length - mid)
                right = mid;
            else
                left = mid + 1;
        }
        return citations.length - left;
    }
}