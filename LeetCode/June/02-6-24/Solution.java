class Solution
{
    public void reverseString(char[] s)
    {
        int i = 0;
        int j = s.length - 1;
        while (i < j)
        {
            swap(s, i, j);
            i++;
            j--;
        }
    }
    
    public void swap(char[] arr, int first, int last)
    {
        char temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}
