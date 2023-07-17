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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int count=0;
        Queue<int []> q=new LinkedList<>();
        
        int row=grid.length;
        int col=grid[0].length;
        int [][]vis=new int[row][col];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i,j});
                    vis[i][j]=1;
                    grid[i][j]=0;
                }
                else
                    vis[i][j]=0;
            }
        }
        while(!q.isEmpty()){
            count=count+1;
            int z=q.size();
            for(int k=0;k<z;k++){
                int[] dr={1,0,-1,0};
                int[] dc={0,1,0,-1};
            
                int[] point=q.poll();
                
            
                for(int i=0;i<4;i++){
                
                    int x=point[0]+dr[i];
                    int y=point[1]+dc[i];
                    
                    if(x>=0 && y>=0 && x<row && y<col && grid[x][y]==0 && vis[x][y]==0) {
                
                        grid[x][y]=count;
                        
                        q.offer(new int []{x,y});
                        vis[x][y]=1;
                    }
                }
            
            }
            
        
    }
        return grid;
    }
}