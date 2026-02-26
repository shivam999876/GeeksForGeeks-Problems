class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        int n1 = s1.length(), n2 = s2.length();
        if (n1 != n2)
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Integer> vis = new HashMap<>(); 

        for (int i = 0; i < n1; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (!map.containsKey(c1)) 
            {
                if (!vis.containsKey(c2)) {
                    map.put(c1, c2);
                    vis.put(c2, 1);
                }
                else if (vis.get(c2) == 1) 
                    return false;
            } 
            else if (map.get(c1) != c2) 
                return false;
        }
        return true;
    }
}