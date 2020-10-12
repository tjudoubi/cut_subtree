import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.ArrayList;

public class cut_subtree {
    public static void run_2(String expr,YListener listener) throws Exception{


        ANTLRInputStream in = new ANTLRInputStream(expr);


        JavaScriptLexer lexer = new JavaScriptLexer(in);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        JavaScriptParser parser = new JavaScriptParser(tokens);
        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();



        walker.walk(listener,tree);



    }


    public static void main(String[] args) throws Exception {
//        String file_path = "D:/datasetforTBCCD-master/jsc-CVE/";
        String file_string = "D:\\cut_subtree\\src\\main\\java\\CVE-2052-1991.js";
//        String file_string = args;
        File dir = new File("./pool");
        dir.mkdir();
        YListener listener = new YListener();
        File file = new File(file_string);
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        String res = "";
        String str;
//        System.out.println(file_string);
        while ((str = bf.readLine()) != null) {
            res = res + str;
        }
        run_2(res,listener);

    }
}
