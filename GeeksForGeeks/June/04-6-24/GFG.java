//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        // code here.
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb1 = new StringBuilder("1");
        int i = sb.length()-1; 
       
        while(i>=0 && sb.charAt(i) == '1')
        {
            sb.setCharAt(i, '0');
            i--;
        }
        if(i<0)
           sb.insert(0,"1");
        else
           sb.setCharAt(i, '1');
           
       int index = sb.indexOf("1");
       return sb.substring(index).toString();
    }
}
