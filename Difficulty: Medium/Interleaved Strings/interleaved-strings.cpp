//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
  public:
    /*You are required to complete this method */
    int LCS(string &s1, string &s2){
        
        int m = s1.size();
        int n = s2.size();

        vector<int> prev(n+1, 0), curr(n+1, 0);
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1[i-1] == s2[j-1]){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        
        return prev[n];
    
    }  
    
    bool isInterleave(string& s1, string& s2, string& s3) {
        int n = s1.size();
        int m = s2.size();
        int p = s3.size();
        
        if(n+m != p) return false;
        
        int len_1 = LCS(s1, s3);
        
        if(len_1 != n) return false;
        
        int len_2 = LCS(s2, s3);
        
        if(len_2 != m) return false;
        
        return true;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string a, b, c;
        cin >> a;
        cin >> b;
        cin >> c;
        Solution obj;
        if (obj.isInterleave(a, b, c))
            cout << "true" << endl;
        else
            cout << "false" << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends