class MinStack {
    private int minValue;
    private LinkedList<Integer> stackInner = new LinkedList<>();

    public void push(int x) {
        if (stackInner.size() == 0) {
            minValue = x;
        }
        else if (x < minValue) {
            minValue = x;
        }
        stackInner.add(x);
    }

    public void pop() {
        int valueTemp = stackInner.getLast();
        stackInner.removeLast();
        if ((valueTemp == minValue) && (stackInner.size() != 0)) {
            minValue = stackInner.getLast(); 
            Iterator<Integer> itTemp = stackInner.iterator();
            while (itTemp.hasNext()) {
                valueTemp = itTemp.next();
                if (valueTemp < minValue) {
                    minValue = valueTemp;
                }
            } 
        }        
    }

    public int top() {
        return stackInner.peekLast();
    }

    public int getMin() {
        if (stackInner.size() == 0) {
            return -1;
        }
        return minValue;
    }
}
