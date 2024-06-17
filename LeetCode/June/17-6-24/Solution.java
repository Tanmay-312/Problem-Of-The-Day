class Solution
{
    public boolean judgeSquareSum(int c)
    {
        long l = 0;
        long r = (long) Math.sqrt(c);

        while (l <= r)
        {
            long sum = l * l + r * r;
            if (sum == c)
                return true;
            if (sum < c)
                l++;
            else
                r--;
        }

        return false;
    }
}
