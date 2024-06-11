//{ Driver Code Starts
import java.io.*;
import java.util.*;

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

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution
{
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr)
    {
        // code here
        int a[][] = new int[n][2];
        for(int i=0; i<n; i++)
        {
            a[i][0] = arr[i];
            a[i][1] = brr[i];
        }
        Arrays.sort(a, (o1,o2) -> Math.abs(o2[0] - o2[1]) - Math.abs(o1[0] - o1[1]));
        
        long ans=0;
        for(int i[] : a)
        {
            if((i[0] > i[1] && x > 0) || (y == 0))
            {
                ans += i[0];
                x--;
            }
            else
            {
                ans += i[1];
                y--;
            }
        }
        
        return ans;
    }
}
