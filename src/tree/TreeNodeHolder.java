package tree;

class TreeNodeHolder{
    TreeNode node;
    int level;

    public TreeNodeHolder(TreeNode node,int level)
    {
        this.node = node;
        this.level = level;
    }

    public TreeNode getNode() {
        return node;
    }

    public int getLevel() {
        return level;
    }
}
