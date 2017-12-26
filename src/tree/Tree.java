package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    TreeNode root;
    Queue<TreeNode> queue;
    public Tree()
    {
        root = null;
        queue = new LinkedList<TreeNode>();
    }
    public void insert(int value)
    {
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
}
