class Solution {
    public int[] sortedSquares(int[] nums) {
       int n = nums.length;
        int[] result = new int[n]; // Create a new array to store the squares
        
        // Initialize pointers for the left and right ends of the original array
        int left = 0;
        int right = n - 1;
        
        // Initialize an index to store the current position in the result array, starting from the end
        int index = n - 1;
        
        // Loop from the end of the result array to the beginning
        while (index >= 0) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            
            index--;
        }
        
        return result; 
    }
}