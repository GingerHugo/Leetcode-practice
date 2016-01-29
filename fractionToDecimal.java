public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return Integer.toString(0);
        }
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);
        long intPart = numeratorL / denominatorL;
        StringBuilder sBuilder = new StringBuilder();
        // if (intPart == 0) {
        if (((numerator > 0) && (denominator < 0)) || ((numerator < 0) && (denominator > 0))) {
            sBuilder.append('-');
        }
        // }
        if ((numeratorL % denominatorL) == 0) {
            sBuilder.append(intPart);
            return sBuilder.toString();
        }
        int duplicate = -1;
        HashMap<Long, Integer> setDigit = new HashMap<>();
        List<Long> listDigit = new LinkedList<>();

        // if (numerator < 0) {
        //     numerator = -numerator;
        // }
        // if (denominator < 0) {
        //     denominator = -denominator;
        // }
        int index = 0;
        long modeNum = numeratorL % denominatorL;
        while(modeNum != 0){
            numeratorL *= 10;
            long digitNum = (numeratorL / denominatorL) % 10;
            if (setDigit.containsKey(modeNum)) {
                // if ((digitNum != 0) || ((digitNum == 0) && (setDigit.size() > 1))) {
                duplicate = setDigit.get(modeNum);
                // setDigit.put(modeNum, index);
                // listDigit.add(digitNum);
                break;
                // }
            }
            setDigit.put(modeNum, index);
            listDigit.add(digitNum);
            index++;
            modeNum = numeratorL % denominatorL;
            numeratorL = modeNum;
            // numerator = numerator % denominator;
        }
        sBuilder.append(intPart);
        sBuilder.append('.');
        index = 0;
        for (long i: listDigit) {
            if (index == duplicate) {
                sBuilder.append('(');
                // flag = false;
            }
            sBuilder.append(i);
            index++;
        }
        if (duplicate != -1) {
           sBuilder.append(')'); 
        }
        return sBuilder.toString();
    }
}