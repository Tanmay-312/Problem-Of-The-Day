//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String str) 
    {
        // your code here
        Set<Character> set = new HashSet<>();
 
        for (char ch : str.toCharArray()) 
        {
            if (ch >= 'a' && ch <= 'z')
                set.add(ch);
 
            if (ch >= 'A' && ch <= 'Z') 
            {
                ch = Character.toLowerCase(ch);
                set.add(ch);
            }
        }
 
        return set.size() == 26;
    }
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends
