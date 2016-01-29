public class Solution {
    public boolean isNumber(String s) {
        char[] number = s.toCharArray();
        int state = 0;
        boolean needNum = false;
        int afterE = 0;
        int afterD = 0;
        boolean afterNum = false;
        for (char digit : number) {
            if (digit == ' ') {
                if (state == 0) state = 1;
                else if (state == 1 || state == 3) continue;
                else state = 3;
            }
            else if (state == 3) return false;
            else if (digit <= '9' && digit >= '0') {
                // valid case
                state = 2;
                needNum = false;
                afterNum = true;
                if (afterE == 1) afterE = 2;
                if (afterD == 1) afterD = 2;
            }
            else if (digit == '-' || digit == '+') {
                if (state == 0 || state == 1 || (state == 2 && afterE == 1 && !needNum)) {
                    needNum = true;
                    state = 2;
                    if (afterE == 1) afterE = 2;
                }
                else return false;
            }
            else if (digit == 'e') {
                if (state == 2 && !needNum && afterE == 0) afterE = 1;
                else return false;                
            }
            else if (digit == '.') {
                if (state <= 2 && afterE == 0 && !needNum && afterD == 0) {
                    // .1 correct, 3. correct
                    state = 4;  // '. 1' incorrect
                    needNum = true;
                    afterD = 1;
                }
                else return false;
            }
            else return false;
        }
        if (state != 2) {
            if (state == 3) state = 2;
            if (afterNum && needNum && afterD == 1) {
                needNum = false;
                state = 2;
            }
        }
        return state == 2 && afterE != 1 && !needNum ? true : false;    // '  ','0e' incorrect
    }
}