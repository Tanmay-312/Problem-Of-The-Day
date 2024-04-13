//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    static Long reversedBits(Long x) 
    {
        // code here
        StringBuilder sb=new StringBuilder("");
        while(x>0)
        {
            sb.append((char)(x%2+48));
            x=x/2;
        }

        int n=32-sb.length();

        for(int i=0;i<n;i++)
            sb.append((char)(48));

        return Long.parseLong(sb.toString(),2);
    }
};
