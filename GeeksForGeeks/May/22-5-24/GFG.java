//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    static double findSmallestMaxDist(int a[], int k) 
    {
        // code here
        int n=a.length;
        double l=0, r=maxDist(a);
        while(l+1e-6<r)
        {
            double mid = (r+l)/2;
            if(possible(a,n,k,mid))
                r=mid;
            else
                l=mid;
        }
        
        return r;
    }
    
    static boolean possible(int a[],int n,int k,double mid)
    {
        int req=0;
        for(int i=1;i<n;i++)
        {
            double diff = a[i]-a[i-1];
            req += Math.ceil(diff/mid)-1;
        }
        return req<=k;
    }
    
    static double maxDist(int a[])
    {
        int n = a.length;
        double maxDist=0.0;
        
        for(int i=1;i<n;i++)
            maxDist = Math.max(maxDist,a[i]-a[i-1]);
        
        return maxDist;
    }
}
