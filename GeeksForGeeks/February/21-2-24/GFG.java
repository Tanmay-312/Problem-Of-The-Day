//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int countWays(int n, String s) 
    {
        int mod = 1003;
        char[] symbols = s.toCharArray();
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i += 2) 
        {
            if (symbols[i] == 'T') 
            {
                dp[i][i][1] = 1;
            }
            else 
            {
                dp[i][i][0] = 1;
            }
        }

        for (int len = 2; len < n; len += 2) 
        {
            for (int i = 0; i < n - len; i += 2) 
            {
                int j = i + len;
                for (int k = i + 1; k < j; k += 2) 
                {
                    char operator = symbols[k];
                    if (operator == '&') 
                    {
                        dp[i][j][1] = (dp[i][j][1] + (dp[i][k - 1][1] * dp[k + 1][j][1]) % mod) % mod;
                        
                        dp[i][j][0] = (dp[i][j][0] + ((dp[i][k - 1][0] * dp[k + 1][j][0]) % mod
                                        + (dp[i][k - 1][0] * dp[k + 1][j][1]) % mod
                                        + (dp[i][k - 1][1] * dp[k + 1][j][0]) % mod) % mod) % mod;
                    }
                    else if (operator == '|') 
                    {
                        dp[i][j][0] = (dp[i][j][0] + (dp[i][k - 1][0] * dp[k + 1][j][0]) % mod) % mod;
                        
                        dp[i][j][1] = (dp[i][j][1] + ((dp[i][k - 1][1] * dp[k + 1][j][1]) % mod
                                        + (dp[i][k - 1][0] * dp[k + 1][j][1]) % mod
                                        + (dp[i][k - 1][1] * dp[k + 1][j][0]) % mod) % mod) % mod;
                    }
                    else if (operator == '^') 
                    {
                        dp[i][j][1] = (dp[i][j][1] + ((dp[i][k - 1][1] * dp[k + 1][j][0]) % mod
                                        + (dp[i][k - 1][0] * dp[k + 1][j][1]) % mod) % mod) % mod;
                        
                        dp[i][j][0] = (dp[i][j][0] + ((dp[i][k - 1][1] * dp[k + 1][j][1]) % mod
                                        + (dp[i][k - 1][0] * dp[k + 1][j][0]) % mod) % mod) % mod;
                    }
                }
            }
        }

        return dp[0][n - 1][1];
    }
}
