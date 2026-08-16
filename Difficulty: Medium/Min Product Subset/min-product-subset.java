class Solution {
     public int minProd(int[] arr) {
         // code here
         int n = arr.length;
         int negCount = 0, zeroCount = 0;
         int maxNeg = Integer.MIN_VALUE;
         int minPos = Integer.MAX_VALUE;
         long prod = 1;
         for(int x : arr){
             if(x == 0){
                 zeroCount++;
                 continue;
             }
             if(x < 0){
                 negCount++;
                 maxNeg = Math.max(maxNeg, x);
             }
             if(x > 0){
                 minPos = Math.min(minPos, x);
             }
             prod *= x;
         }
         if(zeroCount == n) return 0;
         if(negCount == 0){
             if(zeroCount > 0) return 0;
             return minPos;
         }
         if(negCount % 2 == 1){
             return (int) prod;
         }
         prod /= maxNeg;
         return (int)prod; 
     }
 }