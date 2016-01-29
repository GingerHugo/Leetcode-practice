public class Solution {
    private boolean compareTwo (String a, String b) {
        String tempA = a + b;
        String tempB = b + a;
        for (int i = 0; i < tempA.length(); i++) {
            if ((tempA.charAt(i) - tempB.charAt(i)) > 0) {
                return true;
            }
            else if ((tempA.charAt(i) - tempB.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
    private String[] processing(ArrayList<String> bucket) {
        String[] result = new String[bucket.size()];
        for (int i = 0; i < bucket.size(); i++) {
            int index = i;
            for (int j = 0; j < i; j++) {
                if (compareTwo(bucket.get(i), result[j])) {
                    index = j;
                    for (int k = i; k > index; k--) {
                        result[k] = result[k - 1];
                    }
                    break;
                }
            }
            result[index] = bucket.get(i);
            index++;
        }
        return result;
    }
    public String largestNumber(int[] nums) {
        ArrayList<ArrayList<String>> bucketArray = new ArrayList<ArrayList<String>>(10);
        for(int i = 0; i < 10; i++) {
            bucketArray.add(new ArrayList<String>());
        }
        for (int i = 0; i < nums.length; i++) {
            String sTemp = Integer.toString(nums[i]);
            // if (bucketArray.get('9' - sTemp.charAt(0)) == null) {
            //     bucketArray.get('9' - sTemp.charAt(0)) = new ArrayList<String>();
            // }
            bucketArray.get('9' - sTemp.charAt(0)).add(sTemp);
        }
        StringBuilder resultBuffer = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (bucketArray.get(i) != null) {
                String[] result = processing(bucketArray.get(i));
                for (String sTemp: result) {
                    resultBuffer.append(sTemp);
                }
            }
        }
        String resultString = resultBuffer.toString();
        if (resultString.charAt(0) != '0') {
            return resultString;        
        }
        else {
            return Integer.toString(0);
        }
    }
}