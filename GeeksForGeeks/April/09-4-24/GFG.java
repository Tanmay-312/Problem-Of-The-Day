//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int points[][] = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) points[i][j] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minPoints(points, m, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public int minPoints(int points[][], int m, int n) 
    {
        // Your code goes here
        int[][] dp = new int[m][n];
        
        dp[m-1][n-1] = Math.max(1, 1 - points[m-1][n-1]);
        
        for (int i = m - 1; i >= 0; i--) 
        {
            for (int j = n - 1; j >= 0; j--) 
            {
                if (i == m - 1 && j == n - 1)
                    continue;
                    
                int minPointsRequired = Integer.MAX_VALUE;
                
                if (i + 1 < m)
                    minPointsRequired = Math.min(minPointsRequired, dp[i + 1][j]);
                    
                if (j + 1 < n)
                    minPointsRequired = Math.min(minPointsRequired, dp[i][j + 1]);
                
                dp[i][j] = Math.max(1, minPointsRequired - points[i][j]);
            }
        } 
        return dp[0][0];
    }
}
