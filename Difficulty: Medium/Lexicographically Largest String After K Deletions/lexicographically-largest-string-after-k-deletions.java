class Solution {
    public static String maxSubseq(String s, int k) {
        // code here
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int count = k;
        for(char c : s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
            } else {
                while (!st.isEmpty() && count > 0 && st.peek() < c){
                    st.pop();
                    count--;
                }
                st.push(c);
            }
        }
        while(st.size() > n - k){
            st.pop();
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}