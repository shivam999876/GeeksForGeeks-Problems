class Solution {
    public String firstNonRepeating(String A) {
        // code here
         HashMap<Character,Integer> mm = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < A.length(); i++){
            mm.putIfAbsent(A.charAt(i),0);
            mm.put(A.charAt(i),mm.get(A.charAt(i))+1);
            if(mm.get(A.charAt(i))==1)q.add(A.charAt(i));
            while(q.size()!=0 && mm.get(q.peek())>1)q.remove();
            if(q.size()==0)ans.append('#');
            else ans.append(q.peek());
        }
        return ans.toString();
    }
}