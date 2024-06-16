//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public static ArrayList<Integer> getPrimes(int n)
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-1);
        for (int i=2; i<n; i++)
        {
            if (isPrime(i) && isPrime(n-i))
            {
                list.set(0, i);
                list.set(1, n-i);
                break;
            }
        }
        
        return list;
    }
    
    public static boolean isPrime(int n)
    {
        if (n==0 || n==1)
            return false;
        for(int i=2; i<=Math.sqrt(n); i++)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
