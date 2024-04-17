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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution 
{
    static int mergeAndCount(int arr[], int low, int mid, int high) 
    {
        int swapCount = 0;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int temp1[] = new int[n1], temp2[] = new int[n2];
        
        for(int m=0;m<n1;++m) 
        {
            temp1[m] = arr[low + m];
        }
        for(int m=0;m<n2;++m) 
        {
            temp2[m] = arr[mid + 1 + m];
        }
        
        int i = 0, j = 0, k = low;
        while(i < n1 && j < n2) 
        {
            if(temp1[i] <= temp2[j]) 
            {
                arr[k] = temp1[i];
                ++i;
            }
            else 
            {
                swapCount += (n1 - i);
                arr[k] = temp2[j];
                ++j;
            }
            ++k;
        }
        while(i < n1) 
        {
            arr[k] = temp1[i];
            ++i;
            ++k;
        }
        while(j < n2) 
        {
            arr[k] = temp2[j];
            ++j;
            ++k;
        }
        
        return swapCount;
    }
    
    static int mergeSortAndCount(int arr[], int low, int high) 
    {
        int pairCount = 0;
        if(low < high) 
        {
            int mid = low + (high - low) / 2;
            pairCount += mergeSortAndCount(arr, low, mid);
            pairCount += mergeSortAndCount(arr, mid + 1, high);
            pairCount += mergeAndCount(arr, low, mid, high);
        }
        
        return pairCount;
    }
    
    static int countPairs(int arr[], int n) 
    {
        // Your code goes here
        for(int i=0;i<n;++i)
        {
            arr[i] = i * arr[i];
        }
        
        return mergeSortAndCount(arr, 0, n - 1);
    }
}
