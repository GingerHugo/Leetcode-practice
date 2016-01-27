import java.util.Map.Entry;
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        TreeMap<Integer, TreeSet<Integer>> treeNum = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (treeNum.containsKey(nums[i])) treeNum.get(nums[i]).add(i);
            else {
                TreeSet<Integer> index = new TreeSet<>();
                index.add(i);
                treeNum.put(nums[i], index);
            }
        }
        // int preValue = 0;
        // TreeSet<Integer> preIndex = null;
        for (Entry<Integer, TreeSet<Integer>> element : treeNum.entrySet()) {
            if (element.getValue().size() != 1) {
                Integer pre = null;
                for (Integer index : element.getValue()) {
                    if (pre == null) {
                        pre = index;
                        continue;
                    }
                    else {
                        if ((index - pre) <= k) {
                            return true;
                        }
                        else pre = index;
                    }
                }
            }
            // if (preIndex == null) {
            //     preValue = element.getKey();
            //     preIndex = element.getValue();
            //     continue;
            // }
            // else if ((element.getKey() - preValue) <= t) {
            //     for (Integer pre : preIndex) {
            //         for (Integer index : element.getValue()) {
            //             if ((index - pre) <= k) {
            //                 return true;
            //             }
            //         }
            //     }
            // }
            // preValue = element.getKey();
            // preIndex = element.getValue();
        }
        return false;
    }
}