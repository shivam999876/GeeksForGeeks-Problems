class Solution {
    int maxPeopleDefeated(int p) {
        int i = 1;
        int m = 0;
        while (p >= (m = i * i)) {
            p -= m;
            i++;
        }
        return i - 1;
    }
}