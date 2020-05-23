package root;

import TreeNode.*;

/*
    Grammar:
    code ::= <exp>

    exp ::= <term>
            | <term>[<addop><exp>]

    term ::= <factor>
            | <factor>[<mulop><term>]

    factor ::= ['-']<num>
            | ['-']'('<exp>')'

    num ::= [1-9][0-9]*

    addop ::= '+'
            | '-'

    mulop ::= '*'
            | '/'
 */
public class Parser {
    private Scanner scanner;

    public Parser(Scanner scanner) {
        this.scanner = scanner;
    }

    private int requireNumber() {
        String number = scanner.getNum();

        if (number.length() == 0)
            Util.abort("expect a number");

        return Integer.parseInt(number);
    }

    private char requireRightParenthesis() {
        char rp = scanner.getRightParenthesis();

        if (rp == ' ')
            Util.abort("expect a right parenthesis");

        return rp;
    }

    private Tree parseFactor() {
        if (scanner.getNegative() == '-') {
            // negative exp
            if (scanner.getLeftParenthesis() == '(') {
                Tree exp = this.parseExpression();
                requireRightParenthesis();
                return new Minus(new Lit(0), exp);
            }
            // negative number
            else {
                int number = this.requireNumber();
                return new Lit(0 - number);
            }
        } else {
            // positive exp
            if (scanner.getLeftParenthesis() == '(') {
                Tree exp = this.parseExpression();
                requireRightParenthesis();
                return exp;
            }
            // positive number
            else {
                int number = this.requireNumber();
                return new Lit(number);
            }
        }
    }

    private Tree parseTerm() {
        Tree factor = this.parseFactor();

        char mulop = scanner.getMulOp();

        switch (mulop) {
            case '*':
                Tree term = this.parseTerm();
                return new Times(factor, term);
            case '/':
                term = this.parseTerm();
                return new Div(factor, term);
            default:
                return factor;
        }
    }

    private Tree parseExpression() {
        Tree term = this.parseTerm();

        char addop = scanner.getAddOp();

        switch (addop) {
            case '+':
                Tree exp = this.parseExpression();
                return new Plus(term, exp);
            case '-':
                exp = this.parseTerm();
                return new Minus(term, exp);
            default:
                return term;
        }
    }

    private Tree parseCode() {
        return this.parseExpression();
    }

    public Tree parse() {
        return this.parseCode();
    }
}
