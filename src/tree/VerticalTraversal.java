package tree;

import java.util.*;

public class VerticalTraversal {
    public ArrayList<Integer> generate(Tree tree)
    {
        int height = tree.getHeight();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        Queue<TreeNodeHolder> queue = new LinkedList<TreeNodeHolder>();

        TreeNodeHolder holder = new TreeNodeHolder(tree.root,0);
        queue.add(holder);


        //Assign level to each element of tree and traverse using BFS. left child gets
        // parent.level+1 and right child gets parent.level-1 . Add same level nodes to map
        // Elements of map in decreasing level give the vertical traversal of tree.
        while(!queue.isEmpty())
        {
            holder = queue.remove();
            ArrayList<Integer> list;
            if(map.containsKey(holder.level)) {
                list = map.get(holder.level);
            }
            else {
                list = new ArrayList<Integer>();
            }
            list.add(holder.node.getValue());
            map.put(holder.level, list);
            if(holder.node.getLeft() != null) {
                queue.add(new TreeNodeHolder(holder.node.getLeft(), holder.level + 1));
            }
            if(holder.node.getRight() != null) {
                queue.add(new TreeNodeHolder(holder.node.getRight(), holder.level - 1));
            }
        }


        ArrayList<Integer> list,finalList = new ArrayList<Integer>();
        for(int i = height-1;i>-height;i--)
        {
            list = map.get(i);
            finalList.addAll(list);
        }

        return finalList;
    }
    class TreeNodeHolder{
        TreeNode node;
        int level;

        TreeNodeHolder(TreeNode node,int level)
        {
            this.node = node;
            this.level = level;
        }
    }
}
