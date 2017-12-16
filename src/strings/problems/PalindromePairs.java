package strings.problems;

import strings.Trie;
import strings.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
    List<String> listOfWords;
    public Trie trie;
    Trie reverseTrie;

    public PalindromePairs(List<String> list)
    {
        listOfWords = list;
    }

    public HashMap<String,List<String>> getPalindromePairs()
    {
        trie = new Trie();
        reverseTrie = new Trie();
        HashMap<String,List<String>> hashmap = new HashMap<>();
        for(String word:listOfWords)
        {
            String reverseWord = Utils.reverse(word);

            //check word in reverse trie
            searchInTrie(reverseTrie,word,hashmap,false);
            reverseTrie.insert(reverseWord);

            searchInTrie(trie,reverseWord,hashmap,true);
            trie.insert(word);
        }
        return hashmap;
    }
    private void searchInTrie(Trie trie,String query,HashMap hashMap,Boolean ifReverse)
    {
        //look for string with "query" as a prefix and check if the rest of the query is a palindrome
        ArrayList<String> list = trie.searchPrefixStrings(query);
        String temp;
        for(String word:list)
        {
            temp = word.substring(query.length(),word.length());
            if(Utils.isPalindrome(temp))
            {
                if(ifReverse)
                {
                    putIntoHashmap(hashMap,word,Utils.reverse(query));
                }
                else
                {
                    putIntoHashmap(hashMap,query, Utils.reverse(word));
                }
            }
        }

        //look for strings in Trie which are substrings of query and check if rest of query is a palindrome
        list = trie.searchPartial(query);
        for(String word:list)
        {
            temp = query.substring(word.length(),query.length());
            if(Utils.isPalindrome(temp))
            {
                if(ifReverse)
                {
                    putIntoHashmap(hashMap,word,Utils.reverse(query));
                }
                else
                {
                    putIntoHashmap(hashMap,query, Utils.reverse(word));
                }
            }
        }
    }

    private void putIntoHashmap(HashMap<String,ArrayList<String>> hashMap,String first, String second)
    {
        if(second.isEmpty())        // remove duplicate
            return;
        ArrayList<String> list = new ArrayList<String>();
        if(!hashMap.containsKey(first))
        {
            list.add(second);
        }
        else
        {
            list = hashMap.get(first);
            if(!list.contains(second))      // in case of strings which are exactly reverse of each other, they will be added twice
                list.add(second);
        }
        hashMap.put(first,list);
    }
}
