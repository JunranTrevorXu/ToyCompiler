package root;

import java.nio.file.*;

public class MyReader {
    private String code;
    private int nextPos;
    private int len;

    public MyReader(String codePath) throws Exception {
        code = new String(Files.readAllBytes(Paths.get(codePath)));
        nextPos = 0;
        len = code.length();
    }

    public String getCode() {return code;}

    public boolean hasNext() {return nextPos < len;}

    public char peek() {return code.charAt(nextPos);}

    public char read() {return code.charAt(nextPos++);}
}
