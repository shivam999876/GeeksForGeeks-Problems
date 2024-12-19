//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int cutRod(vector<int> &price) {
        // code here
        int n = price.size() ;
        
        vector<int>prev(n+1 , 0) , curr(n+1,0) ;
        
        for(int i = 0 ; i<=n ; i++){
            prev[i] = i*price[0] ; 
        }
        
        
        for(int ind = 1 ; ind<= n ; ind++){
            for(int N = 0 ; N<=n ; N++){
                int notTake = prev[N] ;
                int take = -1e9 ;
                int rodL = ind+1 ;
                if(rodL<=N){
                    take = price[ind] + curr[N-rodL] ;
                }
                
                curr[N] = max(take, notTake) ;
            }
            prev = curr ;
        }
        
        return prev[n] ;
    
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        vector<int> a;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            a.push_back(number);
        }

        Solution ob;

        cout << ob.cutRod(a) << endl;
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends