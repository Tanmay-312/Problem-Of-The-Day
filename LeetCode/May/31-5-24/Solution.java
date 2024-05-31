class Solution 
{
    public int[] singleNumber(int[] nums) 
    {
        int xors = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
        int lowbit = xors & -xors;
        int[] ans = new int[2];

        // Seperate `nums` into two groups by `lowbit`.
        for (int num : nums)
        {
            if ((num & lowbit) > 0)
                ans[0] ^= num;
            else
                ans[1] ^= num;
        }

        return ans;
    }
}
