



// User function template for JAVA

class Solution {
        public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
        if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            deque.pollFirst();
        }
        while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
            deque.pollLast();
        }
        deque.offerLast(i);
        if (i >= k - 1) {
            res.add(arr[deque.peekFirst()]);
        }
    }
    return res;
}
}