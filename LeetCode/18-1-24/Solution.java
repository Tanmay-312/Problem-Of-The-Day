class Solution
{
    // using 1d DP, but actually not
    public int climbStairs(int n)
    {
        // declaring  two variables to store the count
        int prev = 1;
        int prev2 = 1;
        int curr = 0;
        // Running for loop to count all possible ways
        for (int i = 2; i <= n; i++)
        {
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
