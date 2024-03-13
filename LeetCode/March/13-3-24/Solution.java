class Solution 
{
    public int pivotInteger(int n) 
    {
        int y = (n * n + n) / 2;
        int x = (int) Math.sqrt(y);
        return x * x == y ? x : -1;
    }
}
