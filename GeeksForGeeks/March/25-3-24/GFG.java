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
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) 
    {
        // code here
        ArrayList<String> li = new ArrayList<>();
        solve("",0,0,N,li);
        return li;
    }
    
    void solve(String str,int oneC,int zero,int N,ArrayList<String> li)
    {
        if(str.length()==N)
        {
            li.add(str);
            return;
        }
        
        solve(str+"1", oneC+1,zero,N,li);
        
        if(zero < oneC)
        {
            solve(str+"0",oneC,zero+1,N,li);
        }
    }
}
