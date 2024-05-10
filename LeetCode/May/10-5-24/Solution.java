class Solution 
{
    public int[] kthSmallestPrimeFraction(int[] arr, int k) 
    {
        int n = arr.length;
        double left = 0, right = 1, mid;
        int[] ans = new int[2];

        while (left <= right) 
        {
            mid = left + (right - left) / 2;
            int j = 1, total = 0, num = 0, index = 0;
            double maxFraction = 0;

            for (int i = 0; i < n; ++i) 
            {
                while (j < n && arr[i] >= arr[j] * mid)
                    ++j;
                
                total += n - j;

                if (j < n && maxFraction < arr[i] * 1.0 / arr[j]) 
                {
                    maxFraction = arr[i] * 1.0 / arr[j];
                    num = i;
                    index = j;
                }
            }

            if (total == k) 
            {
                ans[0] = arr[num];
                ans[1] = arr[index];
                break;
            }

            if (total > k)
                right = mid;
            else
                left = mid;
        }

        return ans;
    }
}
