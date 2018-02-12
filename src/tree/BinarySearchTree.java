package tree;

import java.util.ArrayList;

import static HelperFunctions.Utils.maximum;
import static HelperFunctions.Utils.minimum;

public class BinarySearchTree extends Tree{
    public boolean isValid() {
        return isValidUtil(root,null,null);
    }
    /*
    reference : https://leetcode.com/problems/validate-binary-search-tree/description/

    given a binary tree, check if its a Binary Search Tree i.e.
            each  leftSubTree has values  less   than parent node
            each rightSubtree has values greater than parent node

                            A
                           / \
                          B   C
                         /\   /\
                        E  F G  H

                        B, E,F < A
                        C, G,H > A

     */
    private boolean isValidUtil(TreeNode node,Integer low,Integer high) {
        // the idea is to pass a limit [low,high] to each children and check if
        // the node value exists between that limit or not. This limit is different
        // for left and right subtree.
        if (node == null) {
            return true;
        }
        return ((low == null || node.getValue() > low) && (high == null || node.getValue() < high) &&
                isValidUtil(node.getLeft(), low, node.getValue()) && isValidUtil(node.getRight(), node.getValue(), high));
    }
    public boolean isValidBST() {
        int[] arr =isValidBSTUtil(root);
        if(arr[2] == 0 || arr[2] == 1)
            return true;
        return false;
    }
    int[] isValidBSTUtil(TreeNode node) {
        // the idea is to first check BST property for left, right and self node value
        // but there could be some values in the left subtree that are greater than the
        // value of current node, or values in right subtree which are less than that
        // so we are returning an array with maximum and minimum values found so far,
        // and last element of array defines if the subtree is valid BST or not.
        if(node == null) {
            return new int[]{0,0,0};
        }
        boolean isLeft = false;
        boolean isRight = false;

        if(node.getLeft() == null) {
            isLeft =  true;
        }
        else {
            if(node.getLeft().getValue() < node.getValue())
                isLeft = true;
        }
        if(node.right == null) {
            isRight = true;
        }
        else {
            if(node.right.getValue() > node.getValue())
                isRight = true;
        }
        if(!isLeft || !isRight) {
            return new int[]{0,0,-1};
        }

        int[] l = isValidBSTUtil(node.getLeft());
        int[] r = isValidBSTUtil(node.right);

        int min = node.getValue(), max = node.getValue(), valid = -1;

        if(l[2] == -1 || r[2] == -1) {
            // the third element of array is either -1, 0 or 1
            // -1 = non valid BST, 0 means treeNode was null and 1 means the tree is a valid BST
            // l = -1, r =  0
            // l = -1, r =  1
            // l = -1, r = -1
            // l =  0, r = -1
            // l =  1, r = -1
            return new int[]{0,0,-1};
        }

        if(l[2] == 0) {
            if(r[2] != 0) {
                // l = 0, r = 1
                if(r[0] > node.getValue())
                    valid = 1;
                //compare right array and node.getValue()
                min = minimum(min,r[0],r[1]);
                max = maximum(min,r[0],r[1]);
            }
            else
            {
                //l = 0, r = 0
                valid = 1;
            }
        }
        else {
            if(r[2] == 0) {
                // l = 1, r = 0
                if(l[1] < node.getValue())
                    valid = 1;
                //compare left array and node.getValue()
                min = minimum(min,l[0],l[1]);
                max = maximum(max,l[0],l[1]);
            }
            else {
                //l = 1, r = 1
                if(l[1] < node.getValue() && r[0] > node.getValue())
                {
                    //if greatest element of left tree is less than node.getValue()
                    //and
                    //smallest element from right tree is greater than node.getValue()
                    //than this is a valid BST
                    valid = 1;
                }
                //compare left, right array and node.getValue()
                min = minimum(min,l[0],l[1]);
                min = minimum(min,r[0],r[1]);

                max = maximum(max,l[0],l[1]);
                max = maximum(max,r[0],r[1]);
            }
        }
        if(valid == 1 )
            return new int[]{min,max,valid};
        else
            return new int[]{0,0,-1};
    }
    /*
    for a given BST, find the minimum absolute difference between any of its nodes
                            10
                           /  \
                          4    20
                         / \
                        1   9

               here minimum difference is between 10 and 9 i.e 1
     Solution :- lets suppose that node 'A' is going to contribute to the minimum difference,
     so we have to optimize the second node value. There are two ways to do that

     1. in the  left sub-tree, the rightmost value will the  largest value   lower than A
     2. in the right sub-tree, the  leftmost value will the smallest value greater than A

     we are only interested in these values for the minimum difference calculated using node A

     In in-order traversal, both these nodes will succeed and precede the node 'A'. So we will
     find the in-order and for each node, will calculate its difference with adjacent nodes.


                                            or

                                      easy solution is

                                in-order will be a sorted array
                                            and
                  we can very easily obtain minimum difference in sorted array
     */
    public int minimumDiffBetweenNodes()
    {
        ArrayList<Integer> inOrder = inOrder();
        int diff = Integer.MAX_VALUE,localDiff;
        for(int i = 1;i<inOrder.size();i++)
        {
            localDiff = Math.abs(inOrder.get(i)-inOrder.get(i-1));
            if(localDiff < diff)
                diff = localDiff;
        }
        return diff;
    }

}
