class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        Stack<Integer> st = new Stack<>();
        int size = q.size();
        for(int i = 0; i < size / 2; i++){
            st.push(q.poll());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        for(int i = 0; i < size / 2; i++){
            q.add(q.poll());
        }
        for(int i = 0; i < size / 2; i++){
            st.push(q.poll());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
            q.add(q.poll());
        }
    }
}
