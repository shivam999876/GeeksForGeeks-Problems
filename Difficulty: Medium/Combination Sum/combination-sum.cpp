//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
  public:
  void sumComb(int i,vector<int>&arr,int target,vector<vector<int>>&ans,vector<int>&ds){
        //Base case
        if(target==0){
            ans.push_back(ds);
            return;
        }
        
         if (i >= arr.size() || target < 0) {
        return;
    }
        if(target>=arr[i]){
            ds.push_back(arr[i]);
            sumComb(i,arr,target-arr[i],ans,ds);
            ds.pop_back();
        }
        sumComb(i+1,arr,target,ans,ds);
    }
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    vector<vector<int> > combinationSum(vector<int> &arr, int target) {
       
        vector<vector<int>>ans;
        sort(arr.begin(),arr.end());
        vector<int>ds;
        sumComb(0,arr,target,ans,ds);
         sort(ans.begin(), ans.end());
        ans.erase(unique(ans.begin(), ans.end()), ans.end());
        return ans;
    }
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        int sum;
        cin >> sum;
        cin.ignore();
        Solution ob;
        vector<vector<int>> ans = ob.combinationSum(arr, sum);
        if (ans.size() == 0)
            cout << -1 << "\n";
        else {
            for (int i = 0; i < ans.size(); i++) {
                sort(ans[i].begin(), ans[i].end());
            }
            sort(ans.begin(), ans.end());
            for (int i = 0; i < ans.size(); i++) {
                cout << "[";
                for (int u : ans[i])
                    cout << u << " ";
                cout << "] ";
            }
            cout << endl;
        }
        cout << "~\n";
    }

    return 0;
}

// } Driver Code Ends