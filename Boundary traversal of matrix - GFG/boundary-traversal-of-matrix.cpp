//{ Driver Code Starts
#include <bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends

class Solution
{   
    public:
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    vector<int> boundaryTraversal(vector<vector<int> > matrix, int row, int col) 
    {
        // code here
           vector<int> ans;
        if(row==1){
            for(int m=0; m<col; m++){
                ans.push_back(matrix[0][m]);
            }
            return ans;
        }
        if(col==1){
            for(int n=0; n<row; n++){
                ans.push_back(matrix[n][0]);
            }
            return ans;
        }
        for(int i=0; i<col; i++){
        ans.push_back(matrix[0][i]);
        }
        for(int j=1; j<row; j++){
        ans.push_back(matrix[j][col-1]);
        }
        for(int x=col-2; x>=0; x--){
        ans.push_back(matrix[row-1][x]);
        }
        for(int y=row-2; y!=0; y--){
        ans.push_back(matrix[y][0]);
        }
        return ans;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin>>t;
    
    while(t--) 
    {
        int n,m;
        cin>>n>>m;
        vector<vector<int> > matrix(n); 

        for(int i=0; i<n; i++)
        {
            matrix[i].assign(m, 0);
            for( int j=0; j<m; j++)
            {
                cin>>matrix[i][j];
            }
        }

        Solution ob;
        vector<int> result = ob.boundaryTraversal(matrix, n, m);
        for (int i = 0; i < result.size(); ++i)
                cout<<result[i]<<" ";
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends