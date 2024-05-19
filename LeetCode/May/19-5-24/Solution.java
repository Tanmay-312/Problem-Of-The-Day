class Solution 
{
    public long maximumValueSum(int[] nums, int k, int[][] edges) 
    {
        long totalSum = 0;
        int modifiedCount = 0;
        int minModificationDifference = Integer.MAX_VALUE;

        for (int number : nums) 
        {
            totalSum += Math.max(number, number ^ k);
            modifiedCount += ((number ^ k) > number) ? 1 : 0;
            minModificationDifference = Math.min(minModificationDifference, Math.abs(number - (number ^ k)));
        }

        if (modifiedCount % 2 == 0)
            return totalSum;

        return totalSum - minModificationDifference;
    }
}
