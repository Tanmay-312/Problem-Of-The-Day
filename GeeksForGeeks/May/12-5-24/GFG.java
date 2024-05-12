//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int d = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minSteps(d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    static int minSteps(int d) 
    {
        // code here
        int res = steps(d, 0, 0);
        return res;
    }
    
    private static int steps(int d, int i, int j)
    {
        if(i-d >= 0 && (i-d)%2 == 0)
            return j;
        
        j++;
        return steps(d, i+j, j);
    }
}
