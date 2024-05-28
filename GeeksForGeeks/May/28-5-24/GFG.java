//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution 
{
    public static int minimumCost(int n, int w, int[] cost) 
    {
        // code here
        int dp[][] = new int [n][w+1];
        for(int i[] : dp)
            Arrays.fill(i, -1);
        return solve(0, cost, w, dp);
    }
    
    private static int solve(int i, int []arr, int w, int dp[][])
    {
        if(w==0)
            return 0;
        
        if(w<0||i>=arr.length)
            return 100000;
        
        if(dp[i][w]!=-1)
            return dp[i][w];
        
        return dp[i][w] = Math.min(solve(i+1, arr, w, dp), arr[i] + solve(i, arr, w-(i+1), dp));
    }
}
