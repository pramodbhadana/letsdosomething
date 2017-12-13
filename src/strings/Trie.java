package strings;

import java.util.ArrayList;

public class Trie {
    TrieNode root;
    static int noOfCharacters = 26;
    char firstCharacter = 'a';

    public Trie()
    {
        root = new TrieNode(noOfCharacters);
    }
    public void insert(String key)
    {
        if(key == null)
            return ;
        if(key.isEmpty())
            return ;
        TrieNode node = root;
        int length = key.length();
        int index = 0;

        for(int i=0;i<length;i++)
        {
            index = key.charAt(i) - firstCharacter;
            if(node.childNodes[index] == null)
            {
                node.childNodes[index] = new TrieNode(noOfCharacters);
            }
            //node.isWord =false;
            node = node.childNodes[index];
        }
        node.isWord = true;
    }
    private TrieNode searchPrefixNode(String query)
    {
        return searchNode(root, query, 0);
    }
    public Boolean search(String query)
    {
        TrieNode node = searchPrefixNode(query);
        return (node != null && node.isWord) ? true : false;        // return true if leaf node
    }
    private TrieNode searchNode(TrieNode node,String query, int level)
    {
        if(node == null || query == null)
        {
            return null;
        }
        if(query.isEmpty() || level == query.length())      // return the leaf node
        {
            return node;
        }
        int queryIndex = query.charAt(level) - firstCharacter;
        return searchNode(node.childNodes[queryIndex], query, level+1);
    }
    public ArrayList searchPrefixStrings(String prefix)
    {
        ArrayList<String> list = new ArrayList();
        TrieNode prefixNode = searchPrefixNode(prefix);
        searchPrefixStringsUtil(prefixNode,list,new String());
        ArrayList<String> listOfStrings = new ArrayList();
        for(int i=0;i<list.size();i++)          // add prefix to all strings
        {
            String temp = list.get(i);
            temp = prefix + temp;
            listOfStrings.add(temp);
        }
        return listOfStrings;
    }
    private void searchPrefixStringsUtil(TrieNode node,ArrayList list,String temp)
    {
        if(node == null)
            return;
        if(node.isWord)
        {
            list.add(temp);
        }
        for(int i = 0; i<noOfCharacters;i++)
        {
            if(node.childNodes[i] !=null)
            {
                temp += (char)(firstCharacter + i);
                searchPrefixStringsUtil(node.childNodes[i],list,temp);
            }
        }

    }
    public void delete(String key)
    {
        if(key == null || key.isEmpty())
        {
            return ;
        }
        deleteUtil(root,key,0);
    }
    private Boolean deleteUtil(TrieNode node, String key, int level)
    {
        if(level == key.length())
        {
            node.isWord = false;
            if(node.isWord && node.noOfActiveChildren() == 0)
            {
                return true;        // delete this child in backtrack
            }
            else
            {
                return false;
            }
        }
        int queryIndex = key.charAt(level) - firstCharacter;
        if(node.childNodes[queryIndex] != null)
        {
            boolean hasToDelete = deleteUtil(node.childNodes[queryIndex],key,level+1);
            if(hasToDelete)
            {
                node.childNodes[queryIndex] = null;
                if(node.noOfActiveChildren() < 1 && !node.isWord)
                {
                    return true;
                }
            }
        }
        return false;

    }
}
