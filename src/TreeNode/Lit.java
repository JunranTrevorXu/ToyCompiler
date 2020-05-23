package TreeNode;

public class Lit extends Tree {
    private int x;

    public Lit(int x) {
        this.x = x;
    }

    public int getValue() {return x;}
    public Tree getX() {return null;}
    public Tree getY() {return null;}
    public String getTreeType() {return "Lit";}
}
