//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution 
{
    long numberOfPath(int n, int k, int [][]arr) 
    {
        // code here
        long dp[][][] = new long[n][n][k+1];
        
        if(arr[n-1][n-1] <=k)
        {
            dp[n-1][n-1][arr[n-1][n-1]] = 1;
        }
        
        for(int i=n-1; i>=0 ; i--)
        {
            for(int j=n-1; j>=0 ; j--)
            {
                for(int m=1; m <= k ; m++)
                {
                    if(m-arr[i][j] >= 0 && i+1<n)
                    {
                        dp[i][j][m] += dp[i+1][j][m-arr[i][j]];
                    }
                    
                    if(m-arr[i][j] >= 0 && j+1<n)
                    {
                        dp[i][j][m] += dp[i][j+1][m-arr[i][j]];;
                    }
                }
            }
        }
        
        return dp[0][0][k];
    }
}
