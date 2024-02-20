//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        int n = A.length();
        HashSet<String> wordSet = new HashSet<>(B);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) 
        {
            for (int j = 0; j < i; j++) 
            {
                if (dp[j] && wordSet.contains(A.substring(j, i))) 
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n] ? 1 : 0;
    }
}
