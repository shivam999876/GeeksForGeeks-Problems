class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
           Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> (Math.abs(x - a) - Math.abs(x - b)));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
    }
}
}
