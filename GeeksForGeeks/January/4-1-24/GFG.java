//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.singleElement(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int singleElement(int[] arr , int n) 
    {
        // code here
        int result = 0;
        int x, sum;
 
        for (int i = 0; i < 32; i++) 
        {
            sum = 0;
            x = (1 << i);
            for (int j = 0; j < n; j++) 
            {
                if ((arr[j] & x) != 0)
                    sum++;
            }
            
            if ((sum % 3) != 0)
                result |= x;
        }
        
        return result;
    }
}
