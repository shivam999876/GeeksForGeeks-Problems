class Solution {
    public void sortIt(int[] arr) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 != 0) {
                odds.add(num); 
            } else {
                evens.add(num); 
            }
        }
        Collections.sort(odds, Collections.reverseOrder());
        Collections.sort(evens);
        int index = 0;
        for (int num : odds) {
            arr[index++] = num;
        }
        for (int num : evens) {
            arr[index++] = num;
        }
    }
}
