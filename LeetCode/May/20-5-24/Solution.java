class Solution 
{
    public int subsetXORSum(int[] nums) 
    {
        return solve(nums, 0, 0);
    }

    private int solve(int[] nums, int i, int xors) 
    {
        if (i == nums.length)
            return xors;

        int x = solve(nums, i + 1, xors);
        int y = solve(nums, i + 1, nums[i] ^ xors);
        return x + y;
    }
}
