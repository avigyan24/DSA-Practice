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
        int row=grid.length;
        int col=grid[0].length;
        
        int count_oranges=0;
        int ans=0;
        Queue<int []> q=new LinkedList<>();
        int cnt=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                if(grid[i][j]!=0)
                    count_oranges++;
            }
        }
        if(count_oranges==0) return 0;
        int dr[]={0,1,0,-1};
        int dc[]={1,0,-1,0};
        
        while(!q.isEmpty()){
            int size=q.size();
            cnt+=size;
            for(int i=0;i<size;i++){
                
                int point[]=q.poll();
                for(int j=0;j<4;j++){
                    int x=point[0] + dr[j];
                    int y=point[1] + dc[j];
                    
                    if(x<0 || y<0 ||x>=row||y>=col||grid[x][y]==0||grid[x][y]==2) continue;
                    grid[x][y]=2;
                    q.offer(new int[]{x,y});
                }
            }
            if(!q.isEmpty()){
                ans++;
            }
            
        }
        return count_oranges==cnt?ans:-1;
    }
}