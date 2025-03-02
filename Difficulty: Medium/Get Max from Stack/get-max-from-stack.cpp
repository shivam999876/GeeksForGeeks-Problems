//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
  stack<int> s,ms;
    Solution() {
        // code here
        //public: 
            
        
    }

    // Add an element to the top of Stack
    void push(int x) {
        // code here
        s.push(x);
        if(ms.size() == 0 || x >= ms.top())
        {
            ms.push(x);
        }
    }

    // Remove the top element from the Stack
    void pop() {
        // code here
        if (!s.empty()) {
            if (s.top() == ms.top()) {
                ms.pop();
            }
            s.pop();
        }
       
    }

    // Returns top element of the Stack
    int peek() {
        // code here
        if(s.size() > 0)
            return s.top();
        else
            return -1;
    }

    // Finds minimum element of Stack
    int getMax() {
         
        if(ms.size() > 0)
            return ms.top();
        else
            return -1;
        
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;

    while (t--) {
        int q;
        cin >> q;

        Solution ob;

        while (q--) {
            int qt;
            cin >> qt;

            if (qt == 1) {
                // push
                int att;
                cin >> att;
                ob.push(att);
            } else if (qt == 2) {
                // pop
                ob.pop();
            } else if (qt == 3) {
                // peek
                cout << ob.peek() << " ";
            } else if (qt == 4) {
                // getMin
                cout << ob.getMax() << " ";
            }
        }
        cout << endl;
    }
    return 0;
}

// } Driver Code Ends