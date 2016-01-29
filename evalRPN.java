public class Solution {
    private LinkedList<String> numList;
    private void addOperator (Set<String> markSet) {
        markSet.add("+");
        markSet.add("-");
        markSet.add("*");
        markSet.add("/");
    }
    private String calculating (String varA, String varB, String operator) {
        int a = Integer.parseInt(varA);
        int b = Integer.parseInt(varB);
        int c;
        if (operator.equals("+")) {
            c = a + b;
        }
        else if (operator.equals("-")) {
            c = a - b;
        }
        else if (operator.equals("*")) {
            c = a * b;
        }
        else {
            c = a / b;
        }
        return (new Integer(c).toString());
    }
    public int evalRPN(String[] tokens) {
        numList = new LinkedList<>();
        Set<String> markSet = new HashSet<String>();
        addOperator (markSet);
        for (String element : tokens) {
            if (markSet.contains(element)) {
                String varB = numList.getLast();
                numList.removeLast();
                String varA = numList.getLast();
                numList.removeLast();
                numList.add(calculating(varA, varB, element));
            }
            else {
                numList.add(element);
            }
        }
        String result = numList.getLast();
        return Integer.parseInt(result);
    }
}