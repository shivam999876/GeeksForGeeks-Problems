class Solution {
    
    public static String smallestWindow(String s1, String s2) {
        if (s2.length() > s1.length() || s2.isEmpty()) {
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> helper = new HashMap<>();
        int match = 0;
        int n = s2.length();
        String ans = null;
        
        for(int i=0; i<n; i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
        }
        
        int i=0, j=0;
        while(i<s1.length()) {
            char currentChar = s1.charAt(i);
            helper.put(currentChar, helper.getOrDefault(currentChar, 0) + 1);
            
            if(map.containsKey(currentChar) && helper.get(currentChar) <= map.get(currentChar)) {
                match++;
            }
            
            while(match == n) {
                String currentWindow = s1.substring(j, i + 1);
                
                if (ans == null || ans.length() > currentWindow.length()) {
                    ans = currentWindow;
                }
                  
                char leftChar = s1.charAt(j);
                helper.put(leftChar, helper.get(leftChar) - 1);
                
                if(map.containsKey(leftChar) && helper.get(leftChar) < map.get(leftChar))
                    match--;
                
                j++;
            }
            
            i++;
        }
        
        return ans == null ? "" : ans;
    }
}