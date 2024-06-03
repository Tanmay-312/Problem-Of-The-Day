//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int numberOfConsecutiveOnes(int n) {
        // code here
        long mod = (int) 1e9 + 7, res = 1, a = 1, b = 1;
        
        if(n == 1 || n == 2)
            return 1;
            
        for(int i = 3; i <= n; i++) 
        {
            long c = (a + b) % mod;
            a = b;
            b = c;
            
            res = ((res * 1l * 2) + a) % mod;
        }
        
        return (int) res;
    }
}
