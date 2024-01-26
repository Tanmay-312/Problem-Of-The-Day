//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public int smallestSubstring(String S) 
    {
        // Code here
        int n = S.length(), i = 0, j = 0, k = 0, cnt = 0, min_len = Integer.MAX_VALUE;
        int[] freq = new int[3];
        Arrays.fill(freq, 0);
        
        while (k < n) 
        {
            freq[S.charAt(k)-'0']++;
            if (freq[S.charAt(k)-'0'] == 1)
                cnt++;
            
            if (cnt == 3) 
            {
                while (freq[S.charAt(i)-'0'] > 1) 
                {
                    freq[S.charAt(i)-'0']--;
                    i++;
                }
                
                min_len = Math.min(min_len, k-i+1);
                freq[S.charAt(i)-'0']--;
                i++;
                cnt--;
            }
            
            k++;
        }
        
        return (min_len == Integer.MAX_VALUE) ? -1 : min_len;
    }
};
