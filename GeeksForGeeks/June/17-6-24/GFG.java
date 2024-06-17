//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int p1[] = new int[2];
            int q1[] = new int[2];
            int p2[] = new int[2];
            int q2[] = new int[2];
            String S1[] = read.readLine().split(" ");
            p1[0] = Integer.parseInt(S1[0]);
            p1[1] = Integer.parseInt(S1[1]);
            q1[0] = Integer.parseInt(S1[2]);
            q1[1] = Integer.parseInt(S1[3]);
            String S2[] = read.readLine().split(" ");
            p2[0] = Integer.parseInt(S2[0]);
            p2[1] = Integer.parseInt(S2[1]);
            q2[0] = Integer.parseInt(S2[2]);
            q2[1] = Integer.parseInt(S2[3]);
            Solution ob = new Solution();
            String ans = ob.doIntersect(p1, q1, p2, q2);
            // if(ans)
            System.out.println(ans);
            // else
            // System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    String doIntersect(int p1[], int q1[], int p2[], int q2[])
    {
        // code here
        double m1 = (double)(q1[1] - p1[1]) / (double)(q1[0] - p1[0]);
        double m2 = (double)(q2[1] - p2[1]) / (double)(q2[0] - p2[0]);
        
        if (m1 == m2)
            return "false";
        
        boolean chk211 = p2[1]-p1[1] - m1*(p2[0]-p1[0]) > 0 ? true : false;
        boolean chk212 = q2[1]-p1[1] - m1*(q2[0]-p1[0]) > 0 ? true : false;
        boolean chk121 = p1[1]-p2[1] - m2*(p1[0]-p2[0]) > 0 ? true : false;
        boolean chk122 = q1[1]-p2[1] - m2*(q1[0]-p2[0]) > 0 ? true : false;
        
        if ((chk211==true && chk212 == true) || 
                (chk211==false && chk212 == false) || 
                (chk121 == true && chk122 == true) || 
                (chk121 == false && chk122 == false))
        {
            return "false";
        }
        
        return "true";
    }
}
