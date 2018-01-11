import arrays.LongestIncreasingSubsequence;
import arrays.MinimumArrayLengthToSort;
import sorting.MergeSort;
import sorting.QuickSort;
import strings.KMP;
import strings.Trie;
import strings.problems.PalindromePairs;
import tree.LCA;
import tree.Tree;
import tree.VerticalTraversal;

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
        System.out.println("height : "+tree.getHeight());

        LCA lca = new LCA(tree);
        System.out.println(lca.findLCA(4,17));

        int[] input2 = {31,4,1,0,655,-99,43,76,45};
        MergeSort ms = new MergeSort();
        ms.sort(input2,false);
        System.out.println(Arrays.toString(input2));

        int[] input3 = {10, 19, 34, 5, -1, 7, 101, 18};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println("longest increasing subsequence is "+lis.findLIS(input3)+" and the sequence is "+Arrays.toString(lis.generateLISArray(input3)));

        Tree tree2 = new Tree();
        for(int i= 1;i<32;i++)
        {
            tree2.insert(i);
        }

        VerticalTraversal vt = new VerticalTraversal();
        System.out.println("vertical order : "+vt.generate(tree2));

        int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        MinimumArrayLengthToSort var = new MinimumArrayLengthToSort(arr);
        System.out.println("Unsorted array size of unsorted array :"+var.sizeOfUnsortedArray+" start index :"+var.start+" end index :"+var.end);
    }
}
