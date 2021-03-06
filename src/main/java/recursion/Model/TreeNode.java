package recursion.Model;

/**
 * @author xifu.yy
 * @description
 * @date 2021/02/19 15:12
 */
public class TreeNode {

    public int value;

    public TreeNode left;

    public TreeNode right;


    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}