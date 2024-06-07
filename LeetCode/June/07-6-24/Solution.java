class Solution
{
    class Trie
    {
        Trie child[]=new Trie[26];
        boolean isEnd;
    }
    
    public String replaceWords(List<String> dictionary, String sentence)
    {
        Trie root = new Trie();
        
        for (String s: dictionary)
        {
            insert(root,s);
        }
        
        StringBuilder res = new StringBuilder();
        String words[] = sentence.split(" ");
        
        for (int i=0; i<words.length; i++)
        {
            res.append(search(root,words[i]));
            res.append(" ");
        }
        
        res.setLength(res.length()-1);
        return res.toString();
    }

    public String search(Trie root, String key)
    {
        Trie curr = root;
        StringBuilder temp = new StringBuilder();
        
        for (int i=0; i<key.length(); i++)
        {
            int index=key.charAt(i)-'a';
            
            if (curr.child[index] == null)
            {
                return key;
            }
            
            temp.append(key.charAt(i));
            curr=curr.child[index];
            
            if (curr.isEnd == true)
            {
                return temp.toString();
            }
        }

        return key;
    }

    public void insert(Trie root, String key)
    {
        Trie curr=root;
        
        for (int i=0; i<key.length(); i++)
        {
            int index = key.charAt(i)-'a';
            
            if (curr.child[index] == null)
            {
                curr.child[index] = new Trie();
            }
            
            curr = curr.child[index];
        }

        curr.isEnd = true;
    }
}
