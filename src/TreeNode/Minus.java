package TreeNode;

public class Minus extends Tree {
    private Tree x;
    private Tree y;

    public Minus(Tree x, Tree y) {
        this.x = x;
        this.y = y;
    }

    public int getValue() {return 0;}
    public Tree getX() {return x;}
    public Tree getY() {return y;}
    public String getTreeType() {return "Minus";}
}
