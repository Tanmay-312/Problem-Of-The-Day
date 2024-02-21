class Solution 
{
    public int rangeBitwiseAnd(int left, int right) 
    {
        int shiftBits = 0;

        while (left != right) 
        {
            left >>= 1;
            right >>= 1;
            ++shiftBits;
        }

        return left << shiftBits;
    }
}
