//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    boolean sameFreq(String s) 
    {
        // code here
        int arr[]=new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-97]++;
        }
        
        int ans=-1,c=0;
        for(int i : arr)
        {
            if(i!=0)
            {
                if(ans==-1)
                    ans=i;
                
                else if (Math.abs(ans-i)>1)
                    return false;
                
                else if(Math.abs(ans-i)==1 && ++c==2)
                    return false;
            }
        }
        
        return true;
    }
}
