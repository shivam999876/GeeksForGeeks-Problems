class Solution {
    public int minimumStep(int n) {
        // code here
        int c = 0; 
        while(n >= 1){
           c += n%3+1; 
           n /= 3;
        }
        return c-2;
    }
}
