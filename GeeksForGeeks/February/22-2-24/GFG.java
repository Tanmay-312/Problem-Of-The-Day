//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int mod=(int)(1e9+7);
    
    int memoization(int i,int j,String s,String t,int dp[][])
    {
        if(j==t.length())
            return 1;
            
        if(i==s.length())
            return 0;
            
        if(dp[i][j]!=-1)
            return dp[i][j];
            
        int include=0;
        
        if(s.charAt(i)==t.charAt(j))
            include=memoization(i+1,j+1,s,t,dp);
            
        int exclude = memoization(i+1,j,s,t,dp);
        
        return dp[i][j]=(include+exclude)%mod;
    }
    
    
    int  subsequenceCount(String s, String t)
    {
	    // Your code here	
	    int dp[][]=new int[s.length()][t.length()];
	    
	    for(int[] a:dp)
	        Arrays.fill(a,-1);
	    
	    return memoization(0,0,s,t,dp);
    }
}
