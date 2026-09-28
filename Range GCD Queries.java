class Solution {

    int[] tree;

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, 2 * node + 1, start, mid);
        build(arr, 2 * node + 2, mid + 1, end);

        tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
    }

    void update(int node, int start, int end, int index, int value) {
        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(2 * node + 1, start, mid, index, value);
        } else {
            update(2 * node + 2, mid + 1, end, index, value);
        }

        tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
    }

    int query(int node, int start, int end, int l, int r) {

        // Completely outside the range
        if (r < start || end < l) {
            return 0;
        }

        // Completely inside the range
        if (l <= start && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;

        int leftGcd = query(2 * node + 1, start, mid, l, r);
        int rightGcd = query(2 * node + 2, mid + 1, end, l, r);

        return gcd(leftGcd, rightGcd);
    }

    // IMPORTANT: GFG expects this exact method name
    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {

        int n = arr.length;

        tree = new int[4 * n];

        // Build segment tree
        build(arr, 0, 0, n - 1);

        ArrayList<Integer> answers = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 0) {
                // Type 0: range GCD query
                int l = q[1];
                int r = q[2];

                answers.add(query(0, 0, n - 1, l, r));

            } else {
                // Type 1: update
                int index = q[1];
                int value = q[2];

                update(0, 0, n - 1, index, value);
            }
        }

        return answers;
    }
}
