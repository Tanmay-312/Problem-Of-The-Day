//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution 
{
    static int splitArray(int[] arr , int N, int K) 
    {
        // code here
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int num : arr) 
        {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) 
        {
            int mid = low + (high - low) / 2;

            if (isValid(arr, N, K, mid)) 
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }

        return low;
    }

    static boolean isValid(int[] arr, int N, int K, int mid) 
    {
        int count = 0;
        int currSum = 0;

        for (int i = 0; i < N; i++) 
        {
            currSum += arr[i];
            if (currSum > mid) 
            {
                count++;
                currSum = arr[i];
            }
        }

        count++;
        return count <= K;
    }
};
