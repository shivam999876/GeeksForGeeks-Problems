//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                System.out.println(); // Empty string case
                System.out.println("~");
                continue;
            }

            String[] words = line.trim().split("\\s+");
            Solution sol = new Solution();
            String result = sol.longestValidWord(words);
            System.out.println(result);
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    private class Trie{
        Trie[] children= new Trie[26];
        boolean isEnd=false;
    }
     
     Trie root=new Trie();
    
    void insert(String word){
        var curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null) curr.children[c-'a']=new Trie();
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    
    boolean checkAllPrefix(String word){
        var curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int val=c-'a';
            curr=curr.children[val];
            if(!curr.isEnd) return false;
        }
        return true;
    }
    
    public String longestValidWord(String[] words) {
        // code here
        
        for(var w : words){
            insert(w);
        }
        
        var ans="";
        for(var w:words){
          if(w.length()<ans.length()) continue;
          
          if(checkAllPrefix(w)){
              if(w.length()>ans.length()){
                  ans=w;
              }
              else if(w.length()==ans.length() && ans.compareTo(w) >0){
                  ans=w;
              }
          }
        }
        
        return ans;
    }
}