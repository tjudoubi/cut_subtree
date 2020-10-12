import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.ArrayList;

public class test {
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
//        String file_string = "D:\\cut_subtree\\src\\main\\java\\CVE-2052-1991.js";
//        String file_string = args;
        File dir = new File("./pool");
        dir.mkdir();

        String path = "./jsc-a";
        ArrayList<String> files_path = new ArrayList<String>();
        File dir_file = new File(path);
        File[] tempList = dir_file.listFiles();
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {

                files_path.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                //  System.out.println("文件夹：" + tempList[i]);
            }
        }
//        System.out.println(files.toString());


        YListener listener = new YListener();
        for(int i = 0;i < tempList.length;i++) {
            String[] words1 = files_path.get(i).split("\\\\");
            YListener.parent_file_name = words1[words1.length-1];
            System.out.println(words1[words1.length-1]);
            File file = new File(files_path.get(i));
//            String[] words1 = files_path.get(i).split("\\\\");
//            System.out.println(words1[words1.length-1]);
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String res = "";
            String str;
//        System.out.println(file_string);
            while ((str = bf.readLine()) != null) {
                res = res + str;
            }
            run_2(res, listener);
        }

    }
}
