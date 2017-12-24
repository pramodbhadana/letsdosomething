import strings.KMP;
import strings.Trie;
import strings.problems.PalindromePairs;

import java.awt.*;
import java.util.ArrayList;

public class main {
    public static void main(String arg0[]) {
        Trie trie = new Trie();

        trie.insert("pramod");
        trie.insert("pra");
        trie.insert("pram");
        trie.insert("oh");
        trie.insert("ohmy");
        trie.insert("pramode");

        System.out.println(trie.searchPartial("pramode"));

        System.out.println("all the keys starting with pra");
        System.out.println(trie.searchPrefixStrings("pra"));

        ArrayList<String> list = new ArrayList<>();
        list.add("pra");
        list.add("arp");
        list.add("aarp");
        list.add("parp");
        list.add("aa");
        list.add("");
        list.add("pap");


        PalindromePairs pairs = new PalindromePairs(list);
        System.out.println("pairs forming palindromes : "+pairs.getPalindromePairs());

        KMP kmp = new KMP("ABABABCABABABABCABAB");
        System.out.println("here "+kmp.searchPattern("ABABCABAB"));
    }
}
