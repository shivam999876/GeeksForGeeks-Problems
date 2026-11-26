class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
                Set<Character> vowels = new HashSet<>(Set.of('a','e','i','o','u'));
                int count=0;
                for(int i=0; i<s.length(); i++){
                    if(vowels.contains(s.charAt(i))){
                        count++;
                    } 
                    map.put(i,count);
                }
                ArrayList<Integer> ans = new ArrayList<>();
                for(int[] q :queries){
                    int start = map.getOrDefault(q[0]-1,0);
                    int end = map.getOrDefault(q[1],0);
                    ans.add(end-start);
                }
        return ans;
    }
}
