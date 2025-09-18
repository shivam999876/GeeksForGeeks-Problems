class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stk = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr[i % n]) {
                stk.pop();
            }
            if (i < n && !stk.isEmpty()) {
                res.set(i, stk.peek());
            }
            stk.push(arr[i % n]);
        }

        return res;
    }
}