//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public static long sumOfPowers(long a, long b) 
    {
        // code here
        long sum = 0;
        for(long i=a; i<=b; i++)
        {
            sum += pf(i);
        }
        return sum;
    }
    
    
    public static long pf(long n)
    {   
        long count =0;
        while (n%2==0)
        {
            count++;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0)
            {
                count++;
                n /= i;
            }
        }
        if (n > 2)
            count++;
       
       return count;
    }
}
