public class TwoSum {
    private List<Integer> numList = new ArrayList<>();
    private Map<Integer, Integer> table = new HashMap<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        if (table.containsKey(number)) {
            table.put(number, 2);
        }
        else {
            numList.add(number);
            table.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int num : numList) {
            int target = value - num;
            if (target != num && table.containsKey(target)) {
                return true;
            }
            else if (target == num && table.get(target) == 2) {
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);