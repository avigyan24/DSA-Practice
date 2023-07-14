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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        Queue<int []> queue=new LinkedList<>();
        int row=image.length;
        int col=image[0].length;
        int initial_color=image[sr][sc];
        image[sr][sc]=newColor;
        queue.offer(new int[]{sr,sc});
        
        int []dr={0,0,1,-1};
        int[] dc={1,-1,0,0};
        
        while(!queue.isEmpty()){
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                int []point=queue.poll();
                for(int j=0;j<4;j++){
                    int x=point[0]+dr[j];
                    int y=point[1]+dc[j];
                    
                    if(x<0||y<0||x>=row||y>=col||image[x][y]!=initial_color||image[x][y]==newColor) continue;
                    
                    image[x][y]=newColor;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return image;
    }
}