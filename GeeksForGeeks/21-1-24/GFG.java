//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public static int vertexCover(int n, int m, int[][] edges) 
    {
        // code here
        int ans = Integer.MAX_VALUE;
        
        // The use of labels is especially handy when dealing with nested loops. 
        // It allows you to specify which loop the continue or break statement should affect
        // especially when there are multiple levels of nested loops.
        outerloop:
        for(int i = 0; i <= 1 << n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(!((1 << (edges[j][0] - 1) & i) != 0
                        || (1 << (edges[j][1] - 1) & i) != 0))
                        {
                            continue outerloop; // This continues outerloop and not innerloop
                        }
            }
            
            ans = Math.min(ans, Integer.bitCount(i));
        }
        
        return ans;
    }
}
