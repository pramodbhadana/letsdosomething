import strings.Trie;

import java.util.ArrayList;

public class main {
    public static void main(String arg0[]) {
        Trie trie = new Trie();

        trie.insert("pramod");
        trie.insert("pra");
        trie.insert("pram");
        trie.insert("oh");
        trie.insert("ohmy");

        System.out.println(trie.search("pra"));
        trie.delete("pra");
        System.out.println(trie.search("pra"));

        System.out.println("all the keys starting with pra");

        ArrayList<String> list = trie.searchPrefixStrings("pra");
        System.out.println(list);
    }
}
