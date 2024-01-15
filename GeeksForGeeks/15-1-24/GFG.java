//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    
    public int solve(int ind  , int n , int total, int cost[] , int dp[][])
    {
        if(total <= 0)
            return 0;
        
        if(ind == n)
            return 0;
        
        if(dp[ind][total] != -1)
            return dp[ind][total];
        
        int not_pick = solve(ind + 1 , n , total , cost , dp);
        int pick = 0;
        
        if(cost[ind] <= total)
            pick = 1 + solve(ind +1 , n , total-cost[ind] + (int)(0.9 * cost[ind]) , cost , dp);
        
        return dp[ind][total] = Math.max(pick , not_pick);
    }
    
    public int max_courses(int n, int total, int[] cost) 
    {
        int dp[][] = new int [n][total+1];
        for(int arr[] : dp)
            Arrays.fill(arr , -1);
       
       return solve( 0 , n , total , cost , dp);
    }
}
