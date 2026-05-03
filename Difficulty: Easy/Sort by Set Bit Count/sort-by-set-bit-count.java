class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            return Integer.compare(countB, countA); 
        });
        return new ArrayList<>(Arrays.asList(boxed));
    }
}