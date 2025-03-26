//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function Template for C++
class Solution
{
  public:
  vector<string>ans;
  set<string>st;
  bool check(string inter)
  {
      if(st.find(inter)!=st.end())
      {
          return true;
      }
      return false;
  }
    void solve(int i,string s,vector<string>&ck,int n)
    {
        if(i==n)
        {
            string ck1="";
            for(int j=0;j<ck.size();j++)
            {
                ck1+=ck[j];
                if(j!=ck.size()-1)
                ck1+=" ";
            }
            ans.push_back(ck1);
            return;
        }
        string inter="";
        for(int j=i;j<n;j++)
        {
             inter+=s[j];
             if(check(inter))
             {
                 ck.push_back(inter);
                 solve(j+1,s,ck,n);
                 ck.pop_back();
             }
        }
    }
    vector<string> wordBreak(vector<string>& dict, string s)
    {
        for(int i=0;i<dict.size();i++)
        {
            st.insert(dict[i]);
        }
      vector<string>ck;
        int n=s.size();
        solve(0,s,ck,n);
        return ans;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<string> dict;
        string s;
        string line;
        getline(cin, line);
        stringstream ss(line);
        while (ss >> s) {
            dict.push_back(s);
        }
        getline(cin, s);
        Solution ob;
        vector<string> ans = ob.wordBreak(dict, s);
        if (ans.size() == 0)
            cout << "[]\n";
        else {
            sort(ans.begin(), ans.end());
            for (int i = 0; i < ans.size(); i++)
                cout << ans[i] << endl;
        }
        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends