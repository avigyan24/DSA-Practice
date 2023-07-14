//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n=grid.length,m=grid[0].length,ones=0;
        Queue<int []> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                else if(grid[i][j]==1) ones++;
            }
        }
        int ans=0;
        int [][] moves=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size=q.size();
            boolean changed=false;
            while(size-->0){
                int [] cell=q.poll();
                for(int i=0;i<4;i++){
                    int row=moves[i][0]+cell[0],col=moves[i][1]+cell[1];
                    if(row<n && col<m && row>=0 && col>=0 && grid[row][col]==1){
                         grid[row][col]=2;
                         q.add(new int[]{row,col});
                         ones--;
                         changed=true;
                    }
                }
            }
            if(changed) ans++;
        }
        return ones==0?ans:-1;
    }
}