

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        ArrayList<Integer> list = new  ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int l=arr.length;
        for(int i=0;i<l;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i])st.pop();
           
            if(!st.isEmpty())list.add(i-st.peek());
            else list.add(i+1);
            
            st.push(i);        
        }
        return list;
    }
}