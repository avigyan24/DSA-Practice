//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public static boolean isValid(int di, int dj, int n, int m){
        if(di < 0 || dj < 0 || di >= n || dj >= m)
            return false;
            else return true;
    }
    
    public int  Count(int[][] matrix)
    {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) continue;
                
                int count = 0;
                int x = i;
                int y = j;
                
                for (int k = 0; k < 8; k++) {
                    int a = di[k] + x;
                    int b = dj[k] + y;
                    
                    if (isValid(a, b, n, m)) {
                        if (matrix[a][b] == 0) count++;
                    }
                }
                
                if (count % 2 == 0 && count != 0) ans++;
            }
        }
        return ans;
    }
}