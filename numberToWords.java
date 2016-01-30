public class Solution {
    // private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "
    // Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen"
    // , "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    // private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "
    // Sixty", "Seventy", "Eighty", "Ninety"};
    // private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    private void initialize1(String[] table) {
        table[0] = "One";
        table[1] = "Two";
        table[2] = "Three";
        table[3] = "Four";
        table[4] = "Five";
        table[5] = "Six";
        table[6] = "Seven";
        table[7] = "Eight";
        table[8] = "Nine";
        table[9] = "Ten";
        table[10] = "Eleven";
        table[11] = "Twelve";
        table[12] = "Thirteen";
        table[13] = "Fourteen";
        table[14] = "Fifteen";
        table[15] = "Sixteen";
        table[16] = "Seventeen";
        table[17] = "Eighteen";
        table[18] = "Nineteen";
        table[19] = "Zero";
    }

    private void initialize2(String[] table) {
        table[0] = "Twenty";
        table[1] = "Thirty";
        table[2] = "Forty";
        table[3] = "Fifty";
        table[4] = "Sixty";
        table[5] = "Seventy";
        table[6] = "Eighty";
        table[7] = "Ninety";
    }

    private void initialize3(String[] table) {
        table[0] = "Hundred";
        table[1] = "Thousand";
        table[2] = "Million";
        table[3] = "Billion";
    }

    public String numberToWords(int num) {
        String result = "";
        String[] digitTable = new String[20];
        String[] tenTable = new String[8];
        String[] unit = new String[4];
        initialize1(digitTable);
        initialize2(tenTable);
        initialize3(unit);
        int count = 0;
        while (num != 0) {
            int temp = num % 1000;
            if (temp != 0) {
                StringBuilder sb = new StringBuilder();
                int digit = temp % 100;
                temp /= 100;
                if (temp > 0) {
                    sb.append(digitTable[temp - 1]);
                    sb.append(' ');
                    sb.append(unit[0]);
                    sb.append(' ');
                }
                if (digit > 19) {
                    sb.append(tenTable[digit / 10 - 2]);
                    sb.append(' ');
                    if (digit % 10 > 0) {
                        sb.append(digitTable[digit % 10 - 1]);
                        sb.append(' '); 
                    } 
                }
                else if (digit > 0) {
                    sb.append(digitTable[digit - 1]);
                    sb.append(' ');
                }
                if (count > 0) {
                    sb.append(unit[count]);
                    sb.append(' ');
                }
                result = sb.toString() + result;
            }
            num /= 1000;
            count++;
        }
        return result.equals("") ? digitTable[19] : result.trim();
    }
}