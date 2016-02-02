public class Solution {
    private int stage = 0;
    private boolean judgeString(String s) {
        if (s.length() == 0 || s.length() > 3) return false;
        if (Integer.parseInt(s) >= 256) return false;
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        return true;
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        if (stage == 3) { 
            if (!judgeString(s)) return null;
            else {
                result.add(s); 
                return result;
            }
        }
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            if (judgeString(s.substring(0, i))) {
                stage++;
                List<String> temp = restoreIpAddresses(s.substring(i));
                stage--;
                if (temp == null || temp.size() == 0) continue;
                for (String sTemp : temp) {
                    result.add(s.substring(0, i) + "." + sTemp);
                }
            }           
        }
        return result;
    }
}