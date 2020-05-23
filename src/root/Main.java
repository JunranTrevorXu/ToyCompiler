package root;

import TreeNode.Tree;

public class Main {

    public static void main(String[] args) throws Exception {
        MyReader reader = new MyReader("./code");

        Scanner scanner = new Scanner(reader);

        Parser parser = new Parser(scanner);

        Tree ast = parser.parse();

        String visualizedAST = Util.visualizeAST(ast);

        System.out.println(visualizedAST);
    }
}
