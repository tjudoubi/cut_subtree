import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.ArrayList;

public class cut_subtree {
    public static void run_2(String expr) throws Exception{


        ANTLRInputStream in = new ANTLRInputStream(expr);


        JavaScriptLexer lexer = new JavaScriptLexer(in);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        JavaScriptParser parser = new JavaScriptParser(tokens);
        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();


//        YVisitor visitor = new YVisitor();
        YListener listener = new YListener();
//        visitor.visit(tree);
        walker.walk(listener,tree);

//        int length = listener.list.size();
////        System.out.println(length);
//        String content = "";
//        for(int i = 0;i < length;i++){
//            Integer id = listener.list.get(i).id_;
//            String[] ass = listener.list.get(i).interval.split("\\.\\.");
//            Integer len = Integer.valueOf(ass[1])-Integer.valueOf(ass[0]);
//            content += listener.list.get(i).type_+" ,,, "+ass[0]+" ,,, "+ass[1]+" ,,, "+ id.toString() + " ,,, "+ len.toString()+'\n';
//        }
////        System.out.println(content);
//        listener.id = 0;

//        return content;

    }


    public static void main(String[] args) throws Exception {
//        String file_path = "D:/datasetforTBCCD-master/jsc-CVE/";
        String file_string = "D:\\cut_subtree\\src\\main\\java\\CVE-2052-1991.js";
//        String file_string = args;
        File dir = new File("./pool");
        dir.mkdir();
        File file = new File(file_string);
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        String res = "";
        String str;
//        System.out.println(file_string);
        while ((str = bf.readLine()) != null) {
            res = res + str;
        }
        run_2(res);

    }
}
