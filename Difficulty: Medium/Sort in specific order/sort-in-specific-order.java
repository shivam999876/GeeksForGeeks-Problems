class Solution {
    public void sortIt(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, (a, b) -> {
            if (a % 2 == 0 && b % 2 == 1) {
                return 1; 
            } else if (a % 2 == 0 && b % 2 == 0) {
                return a - b; 
            } else if (a % 2 == 1 && b % 2 == 1) {
                return b - a; 
            } else if (a % 2 == 1 && b % 2 == 0) {
                return -1; 
            }
            return 0;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}