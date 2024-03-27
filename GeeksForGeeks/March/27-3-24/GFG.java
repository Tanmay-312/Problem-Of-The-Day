//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public static int solve(int row, int col, int i, int j, int[][] mat, int[][] visited, int cnt)
    {
        if(i==row || i<0 || j==col || j<0 || mat[i][j]==-1 || visited[i][j]==1)
            return Integer.MAX_VALUE;
        
        if(j == col-1)
        {
            return cnt;
        }
        
        visited[i][j] = 1;
        int l1 = solve(row, col, i+1, j, mat, visited, cnt+1);
        int l2 = solve(row, col, i-1, j, mat, visited, cnt+1);
        int l3 = solve(row, col, i, j+1, mat, visited, cnt+1);
        int l4 = solve(row, col, i,j-1, mat, visited, cnt+1);
        
        visited[i][j] = 0;
        
        return Math.min(l1,Math.min(l2, Math.min(l3,l4)));
    }
    
    public static int findShortestPath(int[][] mat) 
    {
        // code here
        int row = mat.length;
        int col = mat[0].length;
        int min = Integer.MAX_VALUE;
        int[][] visited = new int[row][col];
        
        for(int i = 0; i < row; i++ )
        {
            for(int j = 0; j < col; j++)
            {
                if(mat[i][j]==0)
                {
                    if(i-1>=0)
                       mat[i-1][j] = -1; 
                       
                    if(i+1 < row)
                       mat[i+1][j] = -1;
                     
                    if(j-1 >= 0)
                       mat[i][j-1] = -1;
                     
                    if(j+1 < col)
                      mat[i][j+1] = -1;
                      
                     
                }
            }
        }
        
        for(int i = 0; i < row; i++)
        {
            if(mat[i][0] == 1)
                min = Math.min(min, solve(row, col, i, 0, mat, visited,0));
        }
        
        return min == Integer.MAX_VALUE? -1: min+1;
    }
}
