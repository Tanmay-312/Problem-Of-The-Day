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
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int n)
    {
        long mod=1000000007;
        return func(n,1,0,1)%mod;
    }
    
    static long func(int n, int iterations, long sum , int start)
    {
        if(n==0)
        {
            return sum;
        }
        
        int it = iterations;
        
        long pro=1, mod=1000000007;
        
        while(it>0)
        {
            pro=pro*start;
            pro%=mod;
            start++;
            it--;
        }
        
        sum+=pro;
        
        return func(n-1,iterations+1,sum,start); 
    }
}
