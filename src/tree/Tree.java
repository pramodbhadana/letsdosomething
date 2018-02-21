package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    TreeNode root;
    Queue<TreeNode> queue;
    boolean isLastElementAddedNull = false;
    public Tree()
    {
        root = null;
        queue = new LinkedList<TreeNode>();
    }
    public void insert(Integer value)
    {
        // supporting addition of null values in the tree, the idea is to keep track if the value being added
        // is null and update it when next node is inserted. We just have to skip one place in case last element
        // added was null. It is not easy to just update the value as null in first insert as the default value
        // is also null and we are not updating left or right field of the node as -1 or something else to indicate
        // for null values as it breaks the tree structure.
        if(value == null)
        {
            if(isLastElementAddedNull)
            {
                if(queue.element().getLeft() == null)
                {
                     isLastElementAddedNull = false;                //       node added
                                                                    //         /    \
                                                                    //  null added   null(adding now)
                }
                else
                {
                    //          node added                  some other node
                    //           /      \                       /
                    //    node added   null added           null(adding now)
                    // 'isLastElementAdded' needs to remain true still, as we will take
                    // care of this null when next element will be added
                }

                queue.remove();
                return ;
            }
            isLastElementAddedNull = true;
            return;
        }

        if(!queue.isEmpty() && isLastElementAddedNull)
        {
            TreeNode lastElement = queue.element();
            TreeNode newNode = new TreeNode(value);

            if(lastElement.getLeft() == null) {
                //       node added
                //         /    \
                //  null added  value(adding now)

                if (lastElement.getRight() == null) {
                    lastElement.setRight(newNode);
                    queue.remove();
                }
            }
            else
            {
                //       node added                 some other node next in queue
                //         /    \                           /
                //  node added   null added              value(adding now)

                queue.remove();
                lastElement = queue.element();
                if(lastElement.getLeft() == null)
                {
                    lastElement.setLeft(newNode);
                }
            }
            queue.add(newNode);
            isLastElementAddedNull = false;
            return;
        }

        if(queue.isEmpty())     //base case, no element added yet
        {
            root = new TreeNode(value);
            queue.add(root);
            return ;
        }
        TreeNode node = queue.element();
        TreeNode newNode = new TreeNode(value);
        if(node.getLeft() == null)
        {
            node.setLeft(newNode);
            queue.add(newNode);
        }
        else
        {
            node.setRight(newNode);
            queue.add(newNode);
            queue.remove();
        }

    }
    public ArrayList<Integer> inOrder()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrderUtil(root,list);
        return list;
    }
    private void inOrderUtil(TreeNode node,ArrayList<Integer> list)
    {
        if(node == null)
        {
            return;
        }
        inOrderUtil(node.getLeft(),list);
        list.add(node.getValue());
        inOrderUtil(node.getRight(),list);
    }
    public ArrayList<Integer> inOrderIterative()
    {
       ArrayList<Integer> list = new ArrayList<>();
       if(root == null)
           return list;
       TreeNode node = root;
       Stack<TreeNode> stack = new Stack<>();
       while(node != null || !stack.isEmpty())
       {
           while(node != null)
           {
               stack.push(node);
               node = node.getLeft();
           }
           node = stack.pop();
           list.add(node.getValue());
           node = node.getRight();
       }
       return list;
    }
    public int getHeight()
    {
        int height = 0;
        return getHeightUtil(root);
    }
    private int getHeightUtil(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        return Math.max(getHeightUtil(node.getLeft()),getHeightUtil(node.getRight()))+1;
    }

    public ArrayList<ArrayList<Integer>> levelOrder()
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNodeHolder> queue = new LinkedList();

        TreeNodeHolder holder = new TreeNodeHolder(root,0);
        queue.add(holder);


        int height = getHeight();

        for(int i = 0;i<height;i++)
            list.add(new ArrayList<Integer>());

        int totalNodes = (1<<height) - 1;

        while(totalNodes-- > 0)
        {
            holder = queue.remove();

            if(holder.getNode() == null)
                list.get(holder.getLevel()).add(null);
            else
                list.get(holder.getLevel()).add(holder.getNode().getValue());

            queue.add(new TreeNodeHolder(holder.getNode() == null ? null : holder.getNode().getLeft(),holder.getLevel()+1));
            queue.add(new TreeNodeHolder(holder.getNode() == null ? null : holder.getNode().getRight(),holder.getLevel()+1));
        }
        return list;
    }

    public boolean isSymmetric(TreeNode node) {
        if(node == null)
            return true;
        else
            return areTreesMirrorImages(node.getLeft(),node.getLeft());
    }
    public boolean areTreesMirrorImages(TreeNode left, TreeNode right) {
        if(left == null && right == null)
        {
            return true;
        }
        if(left == null || right == null)
        {
            return false;
        }
        return (left.getValue() == right.getValue() && areTreesMirrorImages(left.left,right.right) && areTreesMirrorImages(left.right,right.left));
    }

    /**
     *
     * reference : https://leetcode.com/problems/diameter-of-binary-tree/description/
     *
     *                  1
     *                 / \
     *                2   3
     *               / \
     *              4   5
     *
     *  for a given tree, find the longest path from one node to another node, this path
     *  may or may not pass through the root.
     *
     *  ########## this is not a optimal approach ##########
     *  Idea is to
     *  1. find the inorder traversal of tree with level
     *  2. for every node i in inorder, find the highest level element
     *      a. among the left elements
     *      b. among the right elements
     *  3. the difference between the highest level left element and level of i element is the length of the path
     *  reachable from node i to farthest element in left subtree
     *  4. the difference between the highest level right element and level of i element is the length of the path
     *  reachable from node i to farthest element in right subtree
     *  5. sum of 3 and 4 gives us the length of the maximum path which includes the node i.
     */

    public int diameterOfBinaryTree() {
        ArrayList<TreeNodeHolder> list = new ArrayList<>();
        inOrderWithLevel(root,0,list);
        int j,k;
        int jMax,kMax;
        int diameter = 0;
        int tempDia;

        for(int i=0;i<list.size();i++)
        {

            j = i;jMax = list.get(j).getLevel();
            k = i;kMax = list.get(k).getLevel();

            while(j>=0 && list.get(j).getLevel() >= list.get(i).getLevel())
            {
                //find the highest level element reached in left subtree
                // we check for elements which has level greater than that of node at level i
                // because we have to go down only ie path that goes through node i only
                if(list.get(j).getLevel() > jMax)
                    jMax = list.get(j).getLevel();
                j--;
            }

            while(k<list.size() && list.get(k).getLevel() >= list.get(i).getLevel())
            {
                //find the highest level element reached in right subtree
                if(list.get(k).getLevel() > kMax)
                    kMax = list.get(k).getLevel();
                k++;
            }

            tempDia = jMax - list.get(i).getLevel() + kMax - list.get(i).getLevel();
            if(tempDia>diameter)
                diameter = tempDia;
        }
        return diameter;


    }
    void inOrderWithLevel(TreeNode node,int level,ArrayList<TreeNodeHolder> list)
    {
        if(node == null) {
            return;
        }
        inOrderWithLevel(node.left,level+1,list);
        list.add(new TreeNodeHolder(node,level));
        inOrderWithLevel(node.right,level+1,list);
    }

    int max = Integer.MIN_VALUE;

    public int maximumPathSum() {
        max = Integer.MIN_VALUE;
        path(root);
        return max;
    }

    /**
     *
     * Given a binary Tree, we have to find the maximum sum formed by any path, from any node to any node
     *
     * reference : https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
     *
     *                   9
     *                 /   \
     *                6    -3
     *                     / \
     *                   -6   2
     *                       /  \
     *                      2   -6
     *                      \    /
     *                      -6  -6
     *
     *                  here maximum sum is 16
     *                  6--> 9--> -3--> 2--> 2
     *
     * The idea is to
     * 1. find out sub-solutions from right and left sub trees
     * 2. check the path sum of
     *    a.left, node and right subtree connected
     *    b.left or right whichever has max sum subtree and node connected
     *    c.only current node
     * update the global variable if any one of these 3 is greater
     * 3. return maximum of
     *    a. maximum of right or subtree plus node
     *    b. only node value
     *
     *    i.e. take maximum of left and right and connect it to current node
     *                     or
     *            only current node is taken
     *
     */

    int path (TreeNode node) {
        if(node == null) {
            return 0;
        }
        int l = path(node.getLeft());
        int r = path(node.getRight());

        max = Math.max(max,l+r+node.getValue());
        max = Math.max(max,Math.max(l,r)+node.getValue());
        max = Math.max(max,node.getValue());

        return Math.max(Math.max(l,r)+node.getValue(),node.getValue());
    }
}
