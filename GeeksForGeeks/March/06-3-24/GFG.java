//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        ArrayList<Integer> indices = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        int[] lps = computeLPSArray(pat);
        int i = 0; 
        int j = 0;
        while (i < n) 
        {
            if (pat.charAt(j) == txt.charAt(i)) 
            {
                i++;
                j++;
            }
            if (j == m) 
            {
                indices.add(i - j + 1);
                j = lps[j - 1];
            }
            else if (i < n && pat.charAt(j) != txt.charAt(i)) 
            {
                if (j != 0) 
                {
                    j = lps[j - 1];
                }
                else 
                {
                    i++;
                }
            }
        }
        return indices;
    }
    
    
    private int[] computeLPSArray(String pat) 
    {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0;
        for (int i = 1; i < m; ) 
        {
            if (pat.charAt(i) == pat.charAt(len)) 
            {
                len++;
                lps[i] = len;
                i++;
            }
            else 
            {
                if (len != 0) 
                {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
