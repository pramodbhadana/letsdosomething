package tree;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value)
    {
        setValue(value);
        setLeft(null);
        setRight(null);
    }

    public TreeNode()
    {
        setLeft(null);
        setRight(null);
    }

    public TreeNode getLeft() {
        return left;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
