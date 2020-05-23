package root;

import TreeNode.*;

public class Util {
    public static void abort(String err) {
        System.err.println(err);
        System.exit(1);
    }

    public static String visualizeAST(Tree root) {
        switch (root.getTreeType()) {
            case "Lit":
                return "Lit(" + Integer.toString(root.getValue()) + ")";
            case "Plus":
                return "Plus(" + visualizeAST(root.getX()) + ", " + visualizeAST(root.getY()) + ")";
            case "Minus":
                return "Minus(" + visualizeAST(root.getX()) + ", " + visualizeAST(root.getY()) + ")";
            case "Times":
                return "Times(" + visualizeAST(root.getX()) + ", " + visualizeAST(root.getY()) + ")";
            case "Div":
                return "Div(" + visualizeAST(root.getX()) + ", " + visualizeAST(root.getY()) + ")";
            default:
                return "";
        }
    }
}
