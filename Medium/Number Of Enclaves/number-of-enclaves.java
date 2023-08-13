//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static void dfs(int row,int col,int [][]grid,int [][] vis){
        
        int r=grid.length;
        int c=grid[0].length;
        
        vis[row][col]=1;
        
        int dx[]={-1,1,0,0};
        int dy[]={0,0,1,-1};
        
        for(int i=0;i<4;i++){
            int nrow= row + dx[i];
            int ncol=col + dy[i];
            
            if(nrow>=0 && ncol>=0 && nrow< r && ncol<c && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                
                dfs(nrow,ncol,grid,vis);
            }
        }
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        
        int[][] vis=new int[r][c];
        
        for(int j=0;j<c;j++){
            if(grid[0][j]==1 && vis[0][j]==0){
                dfs(0,j,grid,vis);
            }
            if(grid[r-1][j]==1 && vis[r-1][j]==0){
                dfs(r-1,j,grid,vis);
            }
            
        }
        for(int i=0;i<r;i++){
            if(grid[i][0]==1 && vis[i][0]==0){
                dfs(i,0,grid,vis);
            }
            if(grid[i][c-1]==1 && vis[i][c-1]==0){
                dfs(i,c-1,grid,vis);
            }
            
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    count+=1;
                }
            }
        }
        return count;
    }
}