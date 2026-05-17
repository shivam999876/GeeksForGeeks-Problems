class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                st.push(arr[i]);
            }
            else{
                if(!checkSign(arr[i], st.peek())){
                    st.pop();
                }
                else{
                    st.push(arr[i]);
                }
            }
        }
        List<Integer> list = new ArrayList<>(st);
        return list;
    }
    
    public boolean checkSign(int a, int b){
        return (a>=0 && b>=0) || (a<0 && b<0);
    }
}