//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    static int minValue(String s, int k)
    {
        // code here
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char c:s.toCharArray())
            hm.put(c,hm.getOrDefault(c,0)+1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(Map.Entry<Character,Integer> e:hm.entrySet())
            pq.add(e.getValue());
        
        while(k!=0)
        {
            int freq = pq.remove();
            freq--;
            
            if(freq>0)
                pq.add(freq);
                
            k--;
        }
        
        int ans = 0;
        while(!pq.isEmpty())
        {
            int freq = pq.remove();
            ans = ans + (int)Math.pow(freq,2);
        }
        return ans;
    }
}
