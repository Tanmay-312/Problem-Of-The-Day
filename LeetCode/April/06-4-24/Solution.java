class Solution 
{
    public String minRemoveToMakeValid(String s) 
    {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); ++i)
        {
            if (sb.charAt(i) == '(') 
            {
                stack.push(i);
            }
            else if (sb.charAt(i) == ')') 
            {
                if (stack.isEmpty())
                    sb.setCharAt(i, '#');
                else
                    stack.pop();
            }
        }

        while (!stack.isEmpty())
            sb.setCharAt(stack.pop(), '#');

        return sb.toString().replaceAll("#", "");
    }
}
