class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;
        for(int value : arr){
            if(value < lowerBound){
                return false;
            }
            while(!stack.isEmpty() && value > stack.peek()){
                lowerBound = stack.pop();
            }
            stack.push(value);
        }
        return true;
    }
}