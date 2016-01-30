public class Solution {
    public int[] plusOne(int[] digits) {
    	if (digits.length == 0) {
    		int[] result = new int[1];
    		result[0] = 1;
    		return result;
    	}
        int add = 0;
        int i;
        for (i = digits.length - 1; i >= 0; i--) {
        	add = (digits[i] + 1) / 10;
        	digits[i] = (digits[i] + 1) % 10;        	
        	if (add == 0) {
        		break;
        	}
        }
        if ((i == -1) && (add == 1)) {
        	int[] newArray = new int[digits.length + 1];
        	newArray[0] = 1;
        	for (i = 0; i < digits.length; i++) {
        		newArray[i + 1] = digits[i];
        	}
        	return newArray;
        }
        else {
        	return digits;
        }        
    }
}