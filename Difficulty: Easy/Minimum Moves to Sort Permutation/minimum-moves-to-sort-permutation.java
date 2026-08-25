class Solution {
     public int minMoves(int[] arr) {
       HashMap<Integer,Integer> map = new HashMap<>();
       int ans = Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++){

           if(map.containsKey(arr[i]-1)) map.put(arr[i],map.get(arr[i]-1) + 1);

           else map.put(arr[i],1);

           ans = Math.max(ans,map.get(arr[i]));

       }

       return arr.length - ans;

     }
 }