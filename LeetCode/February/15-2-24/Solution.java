class Solution 
{
    public long largestPerimeter(int[] nums)
    {
        long prefix = Arrays.stream(nums).asLongStream().sum();

        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; --i) 
        {
            prefix -= nums[i];
            if (prefix > nums[i])
                return prefix + nums[i];
        }

        return -1;
    }
}
