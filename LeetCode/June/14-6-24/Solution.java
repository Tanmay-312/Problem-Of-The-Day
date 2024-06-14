class Solution
{
    public int minIncrementForUnique(int[] nums)
    {
        int ans = 0;
        int min = 0;

        Arrays.sort(nums);

        for (int num : nums)
        {
            ans += Math.max(min - num, 0);
            min = Math.max(min, num) + 1;
        }

        return ans;
    }
}
