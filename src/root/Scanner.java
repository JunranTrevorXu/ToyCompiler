package root;

public class Scanner {
    private MyReader reader;

    public Scanner(MyReader reader) {
        this.reader = reader;
    }

    private boolean isSpace(char peek) {
        return peek == ' '
                || peek == '\n'
                || peek == '\r'
                || peek == '\t'
                || peek == '\f';
    }

    private void eatSpace() {
        while (reader.hasNext() && this.isSpace(reader.peek()))
            reader.read();
    }

    private char getDigit() {
        if (reader.hasNext()) {
            int peek = (int)reader.peek() - 48;
            if (peek >= 0 && peek <= 9)
                return reader.read();
        }

        return ' ';
    }

    public String getNum() {
        this.eatSpace();

        char digit = this.getDigit();
        StringBuilder sb = new StringBuilder();
        while (digit != ' ') {
            sb.append(digit);
            digit = this.getDigit();
        }

        return sb.toString();
    }

    public char getAddOp() {
        this.eatSpace();

        if (reader.hasNext() && (reader.peek() == '+' || reader.peek() == '-'))
            return reader.read();

        return ' ';
    }

    public char getMulOp() {
        this.eatSpace();

        if (reader.hasNext() && (reader.peek() == '*' || reader.peek() == '/'))
            return reader.read();

        return ' ';
    }

    public char getNegative() {
        this.eatSpace();

        if (reader.hasNext() && reader.peek() == '-')
            return reader.read();

        return ' ';
    }

    public char getLeftParenthesis() {
        this.eatSpace();

        if (reader.hasNext() && reader.peek() == '(')
            return reader.read();

        return ' ';
    }

    public char getRightParenthesis() {
        this.eatSpace();

        if (reader.hasNext() && reader.peek() == ')')
            return reader.read();

        return ' ';
    }
}
