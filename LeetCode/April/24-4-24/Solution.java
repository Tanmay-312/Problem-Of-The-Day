class Solution 
{
    public int tribonacci(int n) 
    {
        if (n<2)
            return n;

        int prev = 0;
        int curr = 1;
        int next = 1;

        for (int i=3; i<=n; i++)
        {
            int temp = next;
            next = next + curr + prev;
            prev = curr;
            curr = temp;
        }

        return next;
    }
}
