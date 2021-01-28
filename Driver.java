import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {

       ANTLRInputStream input = new ANTLRInputStream(System.in);
        //feed input into lexer
       LittleLexer lex = new LittleLexer(input);

CharStreams.fromFileName(String.valueOf(input));        

        //create token stream used to feed tokens into parser
        CommonTokenStream tok = new CommonTokenStream(lex);
        LittleParser parser = new LittleParser(tok);
        //start parser
        parser.program();
        //check if input follows the grammar
        int errorCount = parser.getNumberOfSyntaxErrors();
        if(errorCount == 0){

            System.out.println("Accepted");

        }else{

            System.out.println("Not accepted");
        }
    }
}