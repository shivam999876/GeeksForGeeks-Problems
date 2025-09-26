class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        // code here
        int n = dq.size();
        if(type == 2){
            k = n - k;
        }
        k %= n;
        while(k > 0){
            int temp = dq.pollLast();
            dq.offerFirst(temp);
            k--;
        }
    }
}