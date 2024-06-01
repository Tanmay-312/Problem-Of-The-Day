//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution 
{
    public static String oddEven(String s) 
    {
        // code here
        int a[] = new int[27];
        for(int i=0; i<s.length(); i++)
            a[s.charAt(i)-'a' + 1]++;
            
        int x=0, y=0;
        
        for(int i=1; i<=26; i++)
        {
            if(a[i]!=0 && (i%2==0 && a[i]%2==0))
                x++;
            if(a[i]!=0 && (i%2!=0 && a[i]%2!=0))
                y++;
        }
        
        return (x+y)%2 == 0 ? "EVEN" : "ODD";
    }
}
