//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution{
    public:
    
    int uglyNumber(int n)
    {
        //your code here
        
        std::vector<int> dp(n);
        dp[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < n; i++) {
            int twoMul = dp[p1] * 2;
            int threeMul = dp[p2] * 3;
            int fiveMul = dp[p3] * 5;
            dp[i] = std::min(twoMul, std::min(threeMul, fiveMul));
            if (dp[i] == twoMul) p1++;
            if (dp[i] == threeMul) p2++;
            if (dp[i] == fiveMul) p3++;
        }
        return dp[n - 1];
    }
};




//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        int res;
        res = ob.uglyNumber(n);

        cout << res;
        cout << "\n";

        cout << "~"
             << "\n";
    }
}
// } Driver Code Ends