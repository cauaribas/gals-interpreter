import interpreter.*;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        String file = "src/tests.txt";

        try {
            Lexico lexico = new Lexico(new FileReader(file));

            Semantico semantico = new Semantico();
            Sintatico sintatico = new Sintatico();

            sintatico.parse(lexico, semantico);
        } catch (LexicalError | SemanticError | SyntaticError e) {
            System.err.println(e);
        }
    }
}