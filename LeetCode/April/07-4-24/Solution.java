class Solution 
{
    public boolean checkValidString(String s) 
    {
        int low = 0;
        int high = 0;

        for (char c : s.toCharArray()) 
        {
            switch (c) 
            {
                case '(':
                    ++low;
                    ++high;
                    break;
                case ')':
                    low = Math.max(0, --low);
                    --high;
                    break;
                case '*':
                    low = Math.max(0, --low);
                    ++high;
                    break;
            }
            
            if (high < 0)
                return false;
        }

        return low == 0;
    }
}
