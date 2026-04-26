class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        int n = a.length ; 
        int m = b.length ; 
        int o = c.length ; 
        int i = 0 , j = 0 , k = 0 ; 
        ArrayList<Integer>list = new ArrayList<>();
        HashSet<Integer>hset = new HashSet<>();
        while(i<n && j<m && k<o)
        {
            int max = Math.max(a[i] ,Math.max(b[j] , c[k]));
            while(i < n && a[i] < max) i++;
            while(j < m && b[j] < max) j++;
            while(k < o && c[k] < max) k++;
            if(i>=n || j>=m || k>=o) break;
            if((a[i]==b[j]) && (b[j]==c[k])) 
            {
                if(!hset.contains(a[i])) 
                {
                    list.add(a[i]);
                    hset.add(a[i]);
                }
                i++;
                j++;
                k++;
            }
        }
        return list;
        
    }
}

