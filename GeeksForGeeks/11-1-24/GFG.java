//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public static String removeKdigits(String S, int K) 
    {
        // code here
        if(S.length()==K)
        {
            return "0";
        }
        
        Stack<Character> st=new Stack();
        int i=0;
        while(i<S.length())
        {
            while(K>0 && !st.isEmpty() && st.peek()>S.charAt(i))
            {
                st.pop();
                K--;
            }
            
            st.push(S.charAt(i));
            i++;
        }
        
        while(K-->0)
        {
            st.pop();
        }
        
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        
        sb=sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
}
