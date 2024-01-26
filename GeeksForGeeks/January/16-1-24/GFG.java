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
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int numberSequence(int m, int n) 
    {
        int[][] dp = new int[n + 1][m + 1];
        return fun(n, 1, m, 0, dp);
    }

    static int fun(int i, int j, int m, int last, int[][] dp) 
    {
        if (i == 0)
            return 1;

        if (dp[i][j] != 0)
            return dp[i][j];

        int ans = 0;
        for (int k = j; k <= m; k++)
            if (last == 0 || k >= 2 * last)
                ans += fun(i - 1, k , m, k, dp);

        dp[i][j] = ans;
        return ans;
    }
}
