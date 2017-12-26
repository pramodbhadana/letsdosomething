import sorting.QuickSort;
import strings.KMP;
import strings.Trie;
import strings.problems.PalindromePairs;
import tree.LCA;
import tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;

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

        int[] input = {-10,2,11,0,1,-100,3,100,6,888,45,72,-1,39};
        QuickSort qs = new QuickSort();
        qs.sort(input,false);
        System.out.println(Arrays.toString(input));

        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(7);
        tree.insert(8);

        System.out.println(tree.inOrder());
    }
}
