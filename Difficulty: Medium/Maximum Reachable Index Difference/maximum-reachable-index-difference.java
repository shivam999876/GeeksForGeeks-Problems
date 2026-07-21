class Solution {
    class Info{
        char ch;
        int idx;
        
        Info(char ch, int idx){
            this.ch = ch;
            this.idx = idx;
        }
    }
    public int maxIndexDifference(String s) {
        // code here
        int n = s.length();
        int min_a_idx = n;
        
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                min_a_idx = Math.min(min_a_idx, i);
            }else{
                if(!map.containsKey(ch)){
                    map.put(ch, new ArrayList<>());
                }
                map.get(ch).add(i);
            }
        }
        if(min_a_idx == n){
            return -1;
        }
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info('a', min_a_idx));
        int ans = 0;
        while(!q.isEmpty()){
            Info curr = q.poll();
            char currCh = curr.ch;
            int currIdx = curr.idx;
            if(currCh == 'z')
            continue;
            char nextCh = (char)(currCh + 1);
            if(!map.containsKey(nextCh)){
                continue;
            }
            for(int nextIdx : map.get(nextCh)){
                if(nextIdx > currIdx){
                    ans = Math.max(ans, nextIdx - min_a_idx);
                    q.offer(new Info(nextCh, nextIdx));
                }
            }
            map.remove(nextCh);
        }
        return ans;
        
    }
}