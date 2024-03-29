//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    bool is_possible_to_get_seats(int count, int m, vector<int>& seats){
        if(m==1){
            if(seats[0]==1 && count==0) return true;
            else if(seats[0]==0 && count==1) return true;
            else if(seats[0]==0 && count>1) return false;
        }
        
        for(int i=0;i<m;i++){
            if(count==0) return true;
            
            if(i==0){
                if(seats[i]==0 && seats[i+1]==0){
                    seats[i]=1;
                    count--;
                }
            }
            
            if(i==m-1){
                if(seats[i]==0 && seats[i-1]==0){
                    seats[i]=1;
                    count--;
                }
            }
            
            if(seats[i]==0 && seats[i-1]==0 && seats[i+1]==0){
                seats[i]=1;
                count--;
            }
        }
        if(count>0) return false;
        return true;
    }
};

//{ Driver Code Starts.

int main(){

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int m;
        cin >> m;
        vector<int> seats(m);
        for (int i = 0; i < m; i++) {
            cin >> seats[i];
        }
        Solution obj;
        if (obj.is_possible_to_get_seats(n, m, seats)) {
            cout << "Yes" << endl;
        }
        else {
            cout << "No" << endl;
        }
    }
}

// } Driver Code Ends