class Solution {
    public static String caseSort(String s) {
        // code here
        int uFreq[] = new int[26];
        int lFreq[] = new int[26];
        
        for(char ch:s.toCharArray())
        {
            if(ch>='A'&&ch<='Z')
            uFreq[ch-'A']++;
            else
            lFreq[ch-'a']++;
        }
        
        int i=0,j=0;
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<s.length();k++)
        {
            if(s.charAt(k)>='a'&&s.charAt(k)<='z')
            {
                while(lFreq[i]==0)
                i++;
                sb.append((char)(i+'a'));
                lFreq[i]--;
            }
            else
            {
                while(uFreq[j]==0)
                j++;
                sb.append((char)(j+'A'));
                uFreq[j]--;
            }
        }
        return sb.toString();
    }
}