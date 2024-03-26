//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ss = new Solution();
            boolean result = ss.isAdditiveSequence(s);
            System.out.println((result == true ? 1 : 0));
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution 
{
    public boolean isAdditiveSequence(String n) 
    {
        // code here
        int m = (int)Math.min(18,n.length());
        
        for(int i=0;i<m;i++)
        {
            int k = 0;
            for(int j=i+1;j<m;j++)
            {
                long a = Long.parseLong(n.substring(k,i+1));
                long b = Long.parseLong(n.substring(i+1,j+1));
                long sum = a+b;
                int l = (sum+"").length();
                
                if(n.substring(j+1).length()>=l)
                {
                    if(Long.parseLong(n.substring(j+1,j+l+1))==sum)
                    {
                        i = j;
                        k = i;
                        j = j+l-1;
                        
                        if(j+1==m-1)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}
