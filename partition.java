private int partition(int[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    while(true) {
        while(i < hi && less(a[++i], a[lo])); // a[lo]) is the pivot
        while(j > lo && less(a[lo], a[--j]));
        if(i >= j) {
            break;
        }
        exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
}

private void shuffle(int a[]) {
    final Random random = new Random();
    for(int ind = 1; ind < a.length; ind++) {
        final int r = random.nextInt(ind + 1);
        exch(a, ind, r);
    }
}