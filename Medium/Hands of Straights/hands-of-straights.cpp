//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
   bool isStraightHand(int n, int x, vector<int> &arr) {
        // code here
        map<int,int>mpp;
        if(n%x!=0){
            return false;
        }
        
        int count = n/x; // this is the number of groups;
        for(int i=0;i<n;i++){
            mpp[arr[i]]++;
        }
        
        while(count>0){
            
            // every group should have x elements 
            auto it = mpp.begin();
            int element = it->first;
            mpp[element]--;
            if(mpp[element]==0){
                mpp.erase(element);
            }
            
            for(int i=1;i<x;i++){
                
                element = element+1;
                if(mpp.find(element)==mpp.end())return false;
                mpp[element]--;
                if(mpp[element]==0){
                    mpp.erase(element);
                }
            }
            count--;
        }
        return true;
        
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, groupSize;
        cin >> N >> groupSize;

        vector<int> hand(N);
        for (int i = 0; i < N; i++) cin >> hand[i];

        Solution obj;
        int ans = obj.isStraightHand(N, groupSize, hand);
        if (ans)
            cout << "True" << endl;
        else
            cout << "False" << endl;
    }
    return 0;
}
// } Driver Code Ends