//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(n, arr)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[])
    {
        // Your code here
        int[][] dp = new int[n][n];
        
        for(int m=0; m<n; m++) 
        {
            for(int i=0, j=m; j<n; i++, j++)
            {
                if(m==0)
                    dp[i][j]=arr[i];
                    
                else if(m==1)
                    dp[i][j]=Math.max(arr[i], arr[j]);
                    
                else
                    dp[i][j]=Math.max(arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]),
                                        arr[j] + Math.min(dp[i+1][j-1],dp[i][j-2]));
            }
        }
        
        return dp[0][n-1];
    }
}
