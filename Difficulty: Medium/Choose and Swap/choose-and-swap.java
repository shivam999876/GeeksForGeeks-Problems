class Solution {
    public String chooseSwap(String s) {
        int n = s.length();
        char c1 = s.charAt(0), c2 = s.charAt(0);
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            arr[ch-'a'] = i;
        }
        
        for(int i=0;i<n;i++) {
            int charKey = s.charAt(i) - 'a';
            boolean found = false;
            if(arr[charKey]!=-1) {
                for(int j=0;j<26;j++) {
                    int currCharKey = j;
                    int currCharIndex = arr[j];
                    if(currCharKey<charKey && currCharIndex>i) {
                        c1 = s.charAt(i);
                        c2 = (char)('a' + currCharKey);
                        found = true;
                        break;
                    }
                }
            }
            arr[charKey] = -1;
            if(found)
                break;
        }
        
        char[] charArray = s.toCharArray();
        for(int i=0;i<charArray.length;i++) {
            if(charArray[i]==c1) {
                charArray[i] = c2;
            } else if(charArray[i]==c2) {
                charArray[i] = c1;
            }
        }
        
        return String.valueOf(charArray);
    }
}