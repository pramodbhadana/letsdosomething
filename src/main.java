import DynamicProgramming.LongestCommonSubstring;
import LinkedList.LinkedList;
import Matrix.Matrix;
import arrays.BestTimeToBuySellStocks;
import arrays.FindPermutationAKASecretSignature;
import arrays.LongestIncreasingSubsequence;
import arrays.MinimumArrayLengthToSort;
import DynamicProgramming.NoOfStatesAcceptedByBinaryDFA;
import sorting.MergeSort;
import sorting.QuickSort;
import strings.KMP;
import strings.Trie;
import strings.problems.DeleteSubstringRepeatedly;
import strings.problems.PalindromePairs;
import tree.BinarySearchTree;
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

        int A[] = {0,2,1};
        int B[] = {1,0,2};
        int C[] = {0};
        int D = 0;
        int states = 3;

        NoOfStatesAcceptedByBinaryDFA mDFA = new NoOfStatesAcceptedByBinaryDFA(A,B,C,D,states);
        int lengthOfString = 2;
        System.out.println("No of String of length "+lengthOfString+" is : "+mDFA.getNoOfAcceptedStates(lengthOfString));

        int rows, columns, num = 1;
        rows = columns = 10;
        int[][] matrixArray = new int[rows][columns];

        //initialize matrix with 1 to rows*columns
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                matrixArray[i][j] = num++;
            }
        }

        Matrix matrix = new Matrix(rows, columns);
        matrix.setMatrix(matrixArray);

        System.out.println("Matrix : ");
        matrix.printMatrix();

        int[][] matrixArray1 = matrix.rotateBy90InAntiClock();
        System.out.println("Matrix after rotation  :");
        matrix.printMatrix(matrixArray1);

        LongestCommonSubstring LCS = new LongestCommonSubstring("abcde","abc");
        System.out.println("Longest common Substring between "+LCS.first+" and "+LCS.second+" is "+LCS.findLCS());

        FindPermutationAKASecretSignature ss = new FindPermutationAKASecretSignature("DID");
        System.out.println(Arrays.toString(ss.findSecretSignature()));

        System.out.println(DeleteSubstringRepeatedly.moves("aaaaaab","ab"));

        Tree newTree =  new Tree();
        ArrayList<Integer> elementList = new ArrayList<>(Arrays.asList(1,2,3,null,null,null,4,5));
        for(Integer element : elementList)
        {
            newTree.insert(element);
        }

        System.out.println("Inorder : "+Arrays.asList(newTree.inOrder()));

        System.out.println("LevelOrder :"+newTree.levelOrder());

        Tree treeNew = new Tree();

        for(int i=1;i<16;i++)
        {
            treeNew.insert(i);
        }

        System.out.println("Inorder Iterative :"+treeNew.inOrderIterative());

        BinarySearchTree bst = new BinarySearchTree();
        elementList = new ArrayList<>(Arrays.asList(10,5,15,null,null,6,20));

        for(Integer element : elementList)
        {
            bst.insert(element);
        }

        System.out.println("Is tree valid BST : "+bst.isValidBST());

        BinarySearchTree newBst = new BinarySearchTree();
        elementList = new ArrayList<>(Arrays.asList(10,4,20,1,9));

        for(Integer element : elementList)
        {
            newBst.insert(element);
        }

        System.out.println("Is tree valid BST : "+newBst.minimumDiffBetweenNodes());


        Tree treee = new Tree();
        elementList = new ArrayList<>(Arrays.asList(1,2,3,null,4,null,5,null,null,6,7,null,null,8,null));

        /**
         *                   1
         *                 /  \
         *                2    3
         *                \    \
         *                4     5
         *                    /  \
         *                   6    7
         *                       /
         *                      8
         */

        for(Integer element : elementList)
        {
            treee.insert(element);
        }
        System.out.println("Diameter of tree is "+treee.diameterOfBinaryTree());

        int[] prices = new int[]{4,1,5,6,11,3,10,1};

        System.out.println("max profit is "+BestTimeToBuySellStocks.maxProfit(prices));

        Tree treeTree = new Tree();
        elementList = new ArrayList<>(Arrays.asList(9,6,-3,null,null,-6,2,null,null,2,-6,null,-6,-6));



        /**
         *                   9
         *                 /   \
         *                6    -3
         *                     / \
         *                   -6   2
         *                       /  \
         *                      2   -6
         *                      \    /
         *                      -6  -6
         */

        for(Integer element : elementList)
        {
            treeTree.insert(element);
        }
        System.out.println("maximum path sum from any node to any node is : "+treeTree.maximumPathSum());

        LinkedList linkedList = new LinkedList();

        elementList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));

        for(Integer element : elementList)
        {
            linkedList.insert(element);
        }

        System.out.println("linked list elements :"+linkedList.printLinkedList());

        linkedList.removeNthElementFromLast(5);

        System.out.println("after removing 5th element from last, linked list is "+linkedList.printLinkedList());

        linkedList.removeNthElementFromLast(7);

        System.out.println("after removing 7th element from last, linked list is "+linkedList.printLinkedList());

        linkedList.reverseList();

        System.out.println("linked list after reversing : "+linkedList.printLinkedList());
    }
}
