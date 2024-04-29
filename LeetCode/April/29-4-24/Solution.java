class Solution 
{
    public int minOperations(int[] nums, int k) 
    {
        int xors = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
        return Integer.bitCount(k ^ xors);
    }
}
