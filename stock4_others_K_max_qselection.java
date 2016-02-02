public int maxProfit(int k, int[] prices) {
    // find peaks and valleys. for consecutive p k pairs
    // (v1, p1) and (v2, p2) if v1 < v2 and p1 < p2. it makes
    // sense to regroup them into (v1, p2) and (v2, p1) so that
    // when only 1 trade is allowed, we could pick the bigger gap
    // to get the maximum profit
    int len = prices.length;
    int p = 0, v = 0;
    Stack<Point> pair = new Stack();
    ArrayList<Integer> profit = new ArrayList();
    while (p < len){
        for (v = p; v < len - 1 && prices[v] >= prices[v + 1]; v++);
        for (p = v + 1; p < len && prices[p] >= prices[p - 1]; p++);
        while (!pair.isEmpty() && prices[v] <= prices[pair.peek().x]){
            profit.add(prices[pair.peek().y - 1] - prices[pair.peek().x]);
            pair.pop();
        }
        while (!pair.isEmpty() && prices[p - 1] > prices[pair.peek().y - 1]){
            profit.add(prices[pair.peek().y - 1] - prices[v]);
            v = pair.peek().x;
            pair.pop();
        }
        pair.push(new Point(v, p));
    }
    while (!pair.isEmpty()){
        profit.add(prices[pair.peek().y - 1] - prices[pair.peek().x]);
        pair.pop();
    }
    // only needs to sum up the first k elements;
    // best to use quick selection which is an O(n) algorithm
    if (k < profit.size()) quickSelection(profit, k);
    int total = 0;
    for (int i = 0; i < profit.size() && k > 0; i++, k--){
        total += profit.get(i);
    }
    return total;
}
void quickSelection(ArrayList<Integer> nums, int k){
    if (k > nums.size()) return;
    int cur = 0, head = 0, end = nums.size() - 1;
    while (cur != k){
        cur = partition(nums, head, end);
        if (cur > k) end = cur - 2;
        else if (cur < k) head = cur;
    }
}

int partition(ArrayList<Integer> nums, int head, int end){
    // use median of three to get pivot point
    if (end > head + 1){
        // move the median to the end as a pivot, largest to the front
        int[] med = new int[3];
        int m = head + (end - head) / 2;
        med[0] = nums.get(head);
        med[1] = nums.get(m);
        med[2] = nums.get(end);
        Arrays.sort(med);
        nums.set(head, med[2]);
        nums.set(m, med[0]);
        nums.set(end, med[1]);
    }
    int p = head, pivot = nums.get(end);
    for (int i = head; i < end; i++){
        if (nums.get(i) > pivot){
            int tmp = nums.get(p);
            nums.set(p, nums.get(i));
            nums.set(i, tmp);
            p++;
        }
    }
    nums.set(end, nums.get(p));
    nums.set(p, pivot);
    return p + 1;
}