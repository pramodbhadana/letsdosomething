package tree;

public class LCA {
    Tree tree;
    public LCA(Tree tree)
    {
        this.tree = tree;
    }

    public int findLCA(int first, int second)
    {
        return findLCAUtil(tree.root,first,second);
    }

    private int findLCAUtil(TreeNode node, int first, int second)
    {
        if(node == null)
        {
            return -Integer.MAX_VALUE;
        }
        int value = node.getValue(),left,right;
        boolean oneFound = false;
        if(value == first || value == second)
        {
            oneFound = true;
        }
        left = findLCAUtil(node.getLeft(),first,second);
        right = findLCAUtil(node.getRight(),first,second);

        if(!oneFound)
        {
            if(left == 0 && right == 0)
                return value;
            else if(left == 0 || right == 0)
                return 0;
            else if(left > 0)
                return left;
            else if(right > 0)
                return right;
            else
                return -Integer.MAX_VALUE;
        }
        else
        {
            if(left == 0 || right == 0)
                return value;
            return 0;
        }
    }
}
