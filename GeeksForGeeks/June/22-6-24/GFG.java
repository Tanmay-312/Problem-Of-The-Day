//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    long ExtractNumber(String sentence)
    {
        // code here
        long result = -1;
        String[] strArray = sentence.split(" ");
        for(int i=0;i<strArray.length;i++)
        {
            if(Character.isDigit(strArray[i].charAt(0)))
            {
                if(!(strArray[i].contains("9")))
                    result = Math.max(result, Long.parseLong(strArray[i]));
            }
        }
        return result;
    }
}
