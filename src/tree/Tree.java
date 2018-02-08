package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
}
