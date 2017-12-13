package strings;

public class TrieNode {
    TrieNode[] childNodes;
    Boolean isWord;
    int noOfCharacters;

    TrieNode(int noOfCharacters)
    {
        this.noOfCharacters = noOfCharacters;
        childNodes = new TrieNode[noOfCharacters];
        isWord =false;
    }
    int noOfActiveChildren()
    {
        int activeChildren = 0;
        for(int i = 0; i<noOfCharacters; i++)
        {
            if(this.childNodes[i] != null)
                activeChildren++;
        }
        return activeChildren;
    }
}