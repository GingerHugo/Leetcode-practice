public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heightSet = new ArrayList<>();
        List<int[]> resultList = new ArrayList<>();
        for (int[] building : buildings) {
            heightSet.add(new int[]{building[0], -building[2]});
            heightSet.add(new int[]{building[1], building[2]});
        }
        Collections.sort(heightSet, (a,b) -> {return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];});
        TreeMap<Integer, Integer> heightQueue = new TreeMap<>(Collections.reverseOrder());
        heightQueue.put(0,1);
        int height = 0;
        for (int[] corner : heightSet) {
            if (corner[1] < 0) {
                Integer cur = heightQueue.get(-corner[1]);
                cur = (cur == null) ? 1 : cur + 1;
                heightQueue.put(-corner[1], cur);
                // if (height < -corner[1]) {
                //  resultList.add(new int[]{});
                // }
                // height = Math.max(height, -corner[1]);
            }
            else {
                Integer cur = heightQueue.get(corner[1]);
                if (cur == 1) {
                    heightQueue.remove(corner[1]);
                }
                else heightQueue.put(corner[1], cur - 1);
            }
            if (height != heightQueue.firstKey()) {
                height = heightQueue.firstKey();
                resultList.add(new int[]{corner[0], height});
            }
        }
        return resultList;
    }
} 