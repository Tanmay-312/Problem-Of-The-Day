//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException 
    { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    static int help(String A,String B,String C,int i,int j,int k,int n1,int n2,int n3,int dp[][][])
    {
            if(i==n1 || j==n2 || k==n3)
                return 0;
            if(dp[i][j][k]!=-1)
                return dp[i][j][k];
            if(A.charAt(i)==B.charAt(j) && A.charAt(i)==C.charAt(k))
            {
                return dp[i][j][k]=1+help(A,B,C,i+1,j+1,k+1,n1,n2,n3,dp);
            }
            
            int a = help(A,B,C,i+1,j,k,n1,n2,n3,dp);
            int b = help(A,B,C,i,j+1,k,n1,n2,n3,dp);
            int c = help(A,B,C,i,j,k+1,n1,n2,n3,dp);
            
            return dp[i][j][k]= Math.max(a,Math.max(b,c));
    }
    
    
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int dp[][][] = new int[n1][n2][n3];
        for(int temp[][]:dp)
        {
            for(int temp2[]:temp)
            {
                Arrays.fill(temp2,-1);
            }
        }
        return help(A,B,C,0,0,0,n1,n2,n3,dp);
    }
}
