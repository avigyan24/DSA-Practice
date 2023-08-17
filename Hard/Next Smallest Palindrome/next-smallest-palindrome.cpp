//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends
//User function template for C++
//User function template for C++
class Solution{
public:
	vector<int> generateNextPalindrome(int num[], int n) {
	    // code here
	    bool f = 0;
	    int i = 0;
	    int j = n-1;
	    while(i<j){
	        if(num[i]==num[j]){
	            i++;
	            j--;
	        }
	        else if(num[i]>num[j]){
	            f = 1;
	            num[j] = num[i];
	            i++;
	            j--;
	        }
	        else{
	            f = 0;
	            num[j] = num[i];
	            i++;
	            j--;
	        }
	    }
	    bool g = 0;
	    if(f==0){
	        if(i==j && num[i]==9){
	            int x = i;
	            while(i<n && j>=0){
	                if(num[i]==num[j] && num[i]==9){
	                    num[i]=0;
	                    num[j]=0;
	                    i++;
	                    j--;
	                }
	                else break;
	            }
	            if(i>=n || j<0){
	                g = 1;
	            }
	            else {
	                num[i]++;
	                num[j]++;
	            }
	            
	        }
	        else if(i==j && num[i]<9){
	            num[i]++;
	        }
	        else if(i!=j && num[i]==9){
	            while(i<n && j>=0){
	                if(num[i]==num[j] && num[i]==9){
	                    num[i]=0;
	                    num[j]=0;
	                    i++;
	                    j--;
	                }
	                else break;
	            }
	            if(i>=n || j<0){
	                g = 1;
	            }
	            else{
	                num[i]++;
	                num[j]++;
	            } 
	        }
	        else{
	            num[i]++;
	            num[j]++;
	        }
	    }
	    vector<int> v;
	    if(g==1)v.push_back(1);
	    for(int i=0;i<n;i++){
	        v.push_back(num[i]);
	    }
	    if(g==1 && v.size()==n+1){
	        v[v.size()-1]=v[0];
	    }
	    return v;
	}

};

//{ Driver Code Starts.


int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int num[n];
        for (int i = 0; i < n; i++) {
            cin >> num[i];
        }
        Solution ob;
        auto ans = ob.generateNextPalindrome(num, n);
        for (auto x : ans) {
            cout << x << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends