

class Solution {
    
    public int catchThieves(char[] arr, int k) {

        // For each police, try to catch the leftmost thief
        // So that police on the right also has thieves to catch.
        
        int thievesCaught = 0;
        
        Queue<Integer> thieves = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'T') {
                thieves.add(i);
            }
        }
        
        for (int i = 0; i < arr.length && !thieves.isEmpty(); i++) {
            if (arr[i] == 'P') {
                
                while (!thieves.isEmpty()) {
                    Integer thiefPosition = thieves.peek();
                    
                    if (thiefPosition > i + k) {
                        break;
                    }
                    
                    if (thiefPosition < i - k) {
                        thieves.remove();
                        continue;
                    }
                    
                    // thief can be caught
                    thieves.remove();
                    thievesCaught++;
                    break;
                }
                
            }
        }
        
        return thievesCaught;
    }
}


