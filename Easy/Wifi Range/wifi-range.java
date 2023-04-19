//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int N, String S, int X) 
    { 
        int[] rangeRight = new int[N];
        int[] rangeLeft = new int[N];
        
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c == '1'){
                rangeRight[i] += 1;
                if(i + X + 1 < N){
                    rangeRight[i+X+1] -= 1;
                }
            }
        }
        
        for(int i=N-1;i>=0;i--){
            char c = S.charAt(i);
            if(c == '1'){
                rangeLeft[i] += 1;
                if(i - X - 1 >= 0){
                    rangeLeft[i - X - 1] -= 1;
                }
            }
        }
        
        
        for(int i=1;i<N;i++){
            rangeRight[i] += rangeRight[i-1];
        }
        
        for(int i=N-2;i>=0;i--){
            rangeLeft[i] += rangeLeft[i+1];
        }
        
        for(int i=0;i<N;i++){
            if(rangeLeft[i] <= 0 && rangeRight[i] <= 0){
                return false;
            }
        }
        
        return true;
        
    }
}