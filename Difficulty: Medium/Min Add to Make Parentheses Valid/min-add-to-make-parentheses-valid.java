class Solution {
    public int minParentheses(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        int count = 0;
        
        for(int i = 0; i<s.length();i++){
            if(st.isEmpty() && s.charAt(i)==')'){
                count++;
            } else if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            } else st.pop();
            
        }
        
        
        return (st.isEmpty())?count:count+st.size();
    }
}