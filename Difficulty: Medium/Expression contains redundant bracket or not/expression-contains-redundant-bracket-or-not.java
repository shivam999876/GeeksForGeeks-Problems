class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                boolean hasOps = false;
                while(!st.isEmpty() && st.peek() != '('){
                    char val = st.pop();
                    if(val == '+' || val == '/' || val == '*' || val == '-'){
                        hasOps = true;
                    }
                    if(val == '(') break;
                }
                if(!st.isEmpty()) st.pop();
                if(!hasOps) return true;
            }else{
                st.push(ch);
            }
        }
        return false;
    }
}
