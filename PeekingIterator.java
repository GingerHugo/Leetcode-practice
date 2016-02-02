// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer cache = null;
    private Iterator<Integer> iter = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) cache = iter.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cache != null) return cache;
        else if (iter.hasNext()) {
            cache = iter.next();
            return cache;
        }
        else return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cache != null) {
            Integer temp = cache;
            cache = null;
            return temp;
        }
        else return iter.next();
    }

    @Override
    public boolean hasNext() {
        if (cache != null) return true;
        else return iter.hasNext();
    }
}