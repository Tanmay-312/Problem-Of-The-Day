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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalCount(String str)
    {
        // Code here
        int i,j,sum=0,ans =1,n = str.length();
        int[][] sums = new int[n][n];
       
        for(i=0;i<n;i++)
        {
           for(j=i;j<n;j++)
           {
               if(i==j)
                   sums[i][j] = str.charAt(j)-'0';
               else
                   sums[i][j] = sums[i][j-1]+ (str.charAt(j)-'0');
           }
       }
       
       int[][] dp = new int[n][n];
       
       Arrays.fill(dp[0],1);
       for(i=1;i<n;i++)
       {
           for(j=i;j<n;j++)
           {
               for(int k=0;k<=i-1;k++)
               {
                   if(sums[k][i-1] <= sums[i][j])
                       dp[i][j] += dp[k][i-1]; 
               }
               
           }
           ans += dp[i][n-1];
       }
       
       return ans;
    }
}
