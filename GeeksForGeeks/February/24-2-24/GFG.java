//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int fn(int n)
    {
        int a=n/2, b=n/3, c=n/4;
        
        if(a+b+c>n)
            return fn(a)+fn(b)+fn(c);
        
        else
            return n;
    }
    
    public int maxSum(int n) 
    { 
        return fn(n);
    }
}
