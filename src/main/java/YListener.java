import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class YListener extends JavaScriptParserBaseListener{
    static int count_if = 0;
    static int count_sele = 0;
    static int count_bl = 0;
    static int count_vs = 0;
    static int count_vd = 0;
    static int count_i = 0;

    static int count_eos = 0;
    static int count_eof = 0;
    static int count_es = 0;
    static int count_exs = 0;
    static int count_do = 0;
    static int count_wh = 0;
    static int count_for = 0;
    static int count_ctn = 0;
    static int count_break = 0;
    static int count_with = 0;
    static int count_swi = 0;
    static int count_case = 0;
    static int count_laS = 0;
    static int count_try = 0;
    static int count_catch = 0;
    static int count_final = 0;
    static int count_fd = 0;
    static int count_pl = 0;
    static int count_fb = 0;
    static int count_al = 0;
    static int count_el = 0;
    static int count_eli = 0;
    static int count_ol = 0;
    static int count_pnvl = 0;
    static int count_pea = 0;
    static int count_get = 0;
    static int count_set = 0;
    static int count_expression = 0;
    static int count_pm = 0;
    static int count_pspl = 0;
    static int count_arg = 0;
    static int count_assign = 0;
    static int count_literal = 0;
    static int count_id = 0;
    static int count_key = 0;
    static int count_rw = 0;
    public static int id = 0;
    class Node{
        String interval;
        int id_;
        String type_;
    };
    ArrayList<Node> list = new ArrayList<>();
    Stack<Integer> index_stack = new Stack<>();
    Stack<Integer> index_terminal = new Stack();
    ArrayList<String> terminal_list = new ArrayList<>();
    public static String parent_file_name;
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
//    YListener(String parent_file_name){
//        YListener.parent_file_name = parent_file_name;
//    }
////////////////////////////normalization用///////////////////////////
    public static int expression_ele = 0;
    public static int variable_decl = 0;
    public static int assign = 0;
    public static int formalparameterarg = 0;
    public static int expression = 0;
    public static int identifier = 0;
    public static int memberindex = 0;
    public static int expression_seq = 0;
    public static int numeric = 0;
    HashMap<String, Integer> map = new HashMap<String, Integer>(){
        {
            put("[",0);put("]",0);put("(",0);put(")",0);put("{",0);put("}",0);put(";",0);
            put(",",0);put("=",0);put("?",0);put("...",0);put(".",0);put("++",0);put("--",0);
            put("+",0);put("-",0);put("~",0);put("!",0);put("*",0);put("/",0);put("%",0);
            put("**",0);put("??",0);put("#",0);put(">>",0);put("<<",0);put(">>>",0);put("<",0);
            put(">",0);put("<=",0);put(">=",0);put("==",0);put("!=",0);put("===",0);put("!==",0);
            put("&",0);put("^",0);put("|",0);put("&&",0);put("||",0);put("*=",0);put("/=",0);
            put("%=",0);put("+=",0);put("-=",0);put("<<=",0);put(">>=",0);put(">>>=",0);put("&=",0);
            put("^=",0);put("|=",0);put("**=",0);put("=>",0);put("null",0);put("true",0);put("false",0);
            put("break",0);put("do",0);put("instanceof",0);put("typeof",0);put("case",0);put("else",0);
            put("new",0);put("var",0);put("catch",0);put("finally",0);put("return",0);put("void",0);put("continue",0);
            put("for",0);put("switch",0);put("while",0);put("debugger",0);put("function",0);put("this",0);put("with",0);
            put("default",0);put("if",0);put("throw",0);put("delete",0);put("in",0);put("try",0);put("as",0);
            put("from",0);put("class",0);put("enum",0);put("extends",0);put("super",0);put("const",0);put("export",0);
            put("import",0);put("async",0);put("await",0);put("implements",0);put("let",0);put("private",0);
            put("public",0);put("interface",0);put("package",0);put("protected",0);put("static",0);put("yield",0);
        }
    };
/////////////////////////////////////////////////////////////////////



    public void add_Node_node(String interval, String type_,int id_){
        Node node_temp = new Node();
        node_temp.interval = interval;
        node_temp.type_ = type_;
        node_temp.id_ = id_;
        list.add(node_temp);
    }

    public void createSubTree(int index_top,int terminal_top,ArrayList<Node> list_temp,int count_s,String type_){
        int begin_index = index_top;
        int end_index = list_temp.size()-1;
        Integer count = count_s;
        String content = "";
        for(int i = begin_index;i <= end_index;i++){
            Integer id = list.get(i).id_;
            String[] ass = list.get(i).interval.split("\\.\\.");
            Integer len = Integer.valueOf(ass[1])-Integer.valueOf(ass[0]);
            content += list.get(i).type_+" ,,, "+ass[0]+" ,,, "+ass[1]+" ,,, "+ id.toString() + " ,,, "+ len.toString()+'\n';
        }
        File dir = new File("D:\\cut_subtree\\pool_structure\\"+type_);
        if(!dir.exists()){
            dir.mkdir();
        }
        FileWriter writer;
        try {
            writer = new FileWriter("D:\\cut_subtree\\pool_structure\\"+type_ + "\\" + parent_file_name + "_"+count.toString() + ".js.structure");
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dir = new File("D:\\cut_subtree\\pool\\"+type_);
        if(!dir.exists()){
            dir.mkdir();
        }
//        File f2 = new File("D:\\cut_subtree\\src\\main\\java\\pool\\"+type_ + "\\" + count.toString() + ".js");
        String code="";
        for(int i = terminal_top;i < terminal_list.size();i++){
            code += terminal_list.get(i);
            code += " ";

        }

        try {
            writer = new FileWriter("D:\\cut_subtree\\pool\\"+type_ + "\\" + parent_file_name + "_" + count.toString() + ".js");
            writer.write(code);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override public void enterProgram(JavaScriptParser.ProgramContext ctx) {

        add_Node_node(ctx.getSourceInterval().toString(),"Program",id);
        id += 1;
//        list.add(node_temp);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitProgram(JavaScriptParser.ProgramContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterSourceElement(JavaScriptParser.SourceElementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"SourceElement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitSourceElement(JavaScriptParser.SourceElementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_sele = count_sele + 1;
        createSubTree(index_top,terminal_top,list,count_sele,"SourceElement");

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatement(JavaScriptParser.StatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Statement",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatement(JavaScriptParser.StatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBlock(JavaScriptParser.BlockContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Block",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBlock(JavaScriptParser.BlockContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_bl = count_bl + 1;
        createSubTree(index_top,terminal_top,list,count_bl,"Block");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatementList(JavaScriptParser.StatementListContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"StatementList",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatementList(JavaScriptParser.StatementListContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterImportStatement(JavaScriptParser.ImportStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ImportStatement",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitImportStatement(JavaScriptParser.ImportStatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterImportFromBlock(JavaScriptParser.ImportFromBlockContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ImportFromBlock",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitImportFromBlock(JavaScriptParser.ImportFromBlockContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterModuleItems(JavaScriptParser.ModuleItemsContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ModuleItems",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitModuleItems(JavaScriptParser.ModuleItemsContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterImportDefault(JavaScriptParser.ImportDefaultContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ImportDefault",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitImportDefault(JavaScriptParser.ImportDefaultContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterImportNamespace(JavaScriptParser.ImportNamespaceContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ImportNamespace",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitImportNamespace(JavaScriptParser.ImportNamespaceContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterImportFrom(JavaScriptParser.ImportFromContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ImportFrom",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitImportFrom(JavaScriptParser.ImportFromContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAliasName(JavaScriptParser.AliasNameContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"AliasName",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAliasName(JavaScriptParser.AliasNameContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExportDeclaration(JavaScriptParser.ExportDeclarationContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ExportDeclaration",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExportDeclaration(JavaScriptParser.ExportDeclarationContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExportDefaultDeclaration(JavaScriptParser.ExportDefaultDeclarationContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ExportDefaultDeclaration",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExportDefaultDeclaration(JavaScriptParser.ExportDefaultDeclarationContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExportFromBlock(JavaScriptParser.ExportFromBlockContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ExportFromBlock",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExportFromBlock(JavaScriptParser.ExportFromBlockContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDeclaration(JavaScriptParser.DeclarationContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Declaration",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDeclaration(JavaScriptParser.DeclarationContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVariableStatement(JavaScriptParser.VariableStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"VariableStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVariableStatement(JavaScriptParser.VariableStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_vs = count_vs + 1;
        createSubTree(index_top,terminal_top,list,count_vs,"VariableStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVariableDeclarationList(JavaScriptParser.VariableDeclarationListContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"VariableDeclarationList",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        variable_decl += 1;
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVariableDeclarationList(JavaScriptParser.VariableDeclarationListContext ctx) {
        variable_decl -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_vd = count_vd + 1;
        createSubTree(index_top,terminal_top,list,count_vd,"VariableDeclarationList");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"VariableDeclaration",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_vd = count_vd + 1;
        createSubTree(index_top,terminal_top,list,count_vd,"VariableDeclaration");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEmptyStatement(JavaScriptParser.EmptyStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"EmptyStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEmptyStatement(JavaScriptParser.EmptyStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_es = count_es + 1;
        createSubTree(index_top,terminal_top,list,count_es ,"EmptyStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpressionStatement(JavaScriptParser.ExpressionStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ExpressionStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpressionStatement(JavaScriptParser.ExpressionStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_exs = count_exs + 1;
        createSubTree(index_top,terminal_top,list,count_exs,"ExpressionStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterIfStatement(JavaScriptParser.IfStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"IfStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIfStatement(JavaScriptParser.IfStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_if = count_if + 1;
        createSubTree(index_top,terminal_top,list,count_if,"IfStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDoStatement(JavaScriptParser.DoStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"DoStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDoStatement(JavaScriptParser.DoStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_do = count_do + 1;
        createSubTree(index_top,terminal_top,list,count_do,"DoStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterWhileStatement(JavaScriptParser.WhileStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"WhileStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWhileStatement(JavaScriptParser.WhileStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_wh = count_wh+ 1;
        createSubTree(index_top,terminal_top,list,count_wh,"WhileStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterForStatement(JavaScriptParser.ForStatementContext ctx) {
//        System.out.println(ctx.getText());
        add_Node_node(ctx.getSourceInterval().toString(),"Block",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitForStatement(JavaScriptParser.ForStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_for = count_for + 1;
        createSubTree(index_top,terminal_top,list,count_for,"ForStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterForInStatement(JavaScriptParser.ForInStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ForInStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitForInStatement(JavaScriptParser.ForInStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_for = count_for  + 1;
        createSubTree(index_top,terminal_top,list,count_for,"ForStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterForOfStatement(JavaScriptParser.ForOfStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ForOfStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitForOfStatement(JavaScriptParser.ForOfStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_for = count_for  + 1;
        createSubTree(index_top,terminal_top,list,count_for,"ForStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVarModifier(JavaScriptParser.VarModifierContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"VarModifier",id);
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVarModifier(JavaScriptParser.VarModifierContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterContinueStatement(JavaScriptParser.ContinueStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ContinueStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitContinueStatement(JavaScriptParser.ContinueStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_ctn = count_ctn + 1;
        createSubTree(index_top,terminal_top,list,count_ctn,"ContinueStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBreakStatement(JavaScriptParser.BreakStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"BreakStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBreakStatement(JavaScriptParser.BreakStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_break = count_break + 1;
        createSubTree(index_top,terminal_top,list,count_break,"BreakStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterReturnStatement(JavaScriptParser.ReturnStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ReturnStatement",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitReturnStatement(JavaScriptParser.ReturnStatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterYieldStatement(JavaScriptParser.YieldStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"YieldStatement",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitYieldStatement(JavaScriptParser.YieldStatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterWithStatement(JavaScriptParser.WithStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"WithStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWithStatement(JavaScriptParser.WithStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_with = count_with + 1;
        createSubTree(index_top,terminal_top,list,count_with,"WithStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterSwitchStatement(JavaScriptParser.SwitchStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"SwitchStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitSwitchStatement(JavaScriptParser.SwitchStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_swi = count_swi + 1;
        createSubTree(index_top,terminal_top,list,count_swi,"SwitchStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCaseBlock(JavaScriptParser.CaseBlockContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"CaseBlock",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCaseBlock(JavaScriptParser.CaseBlockContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_case = count_case + 1;
        createSubTree(index_top,terminal_top,list,count_case,"CaseBlock");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCaseClauses(JavaScriptParser.CaseClausesContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"CaseClauses",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCaseClauses(JavaScriptParser.CaseClausesContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_case = count_case + 1;
        createSubTree(index_top,terminal_top,list,count_case,"CaseBlock");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCaseClause(JavaScriptParser.CaseClauseContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"CaseClause",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCaseClause(JavaScriptParser.CaseClauseContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_case = count_case + 1;
        createSubTree(index_top,terminal_top,list,count_case,"CaseBlock");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDefaultClause(JavaScriptParser.DefaultClauseContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Block",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDefaultClause(JavaScriptParser.DefaultClauseContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterLabelledStatement(JavaScriptParser.LabelledStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"LabelledStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitLabelledStatement(JavaScriptParser.LabelledStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_laS = count_laS + 1;
        createSubTree(index_top,terminal_top,list,count_laS,"LabelledStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterThrowStatement(JavaScriptParser.ThrowStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ThrowStatement",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitThrowStatement(JavaScriptParser.ThrowStatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTryStatement(JavaScriptParser.TryStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"TryStatement",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTryStatement(JavaScriptParser.TryStatementContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_try = count_try + 1;
        createSubTree(index_top,terminal_top,list,count_try,"TryStatement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCatchProduction(JavaScriptParser.CatchProductionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"CatchProduction",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCatchProduction(JavaScriptParser.CatchProductionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_catch = count_catch + 1;
        createSubTree(index_top,terminal_top,list,count_catch,"CatchProduction");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFinallyProduction(JavaScriptParser.FinallyProductionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"FinallyProduction",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFinallyProduction(JavaScriptParser.FinallyProductionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_final= count_final + 1;
        createSubTree(index_top,terminal_top,list,count_final,"FinallyProduction");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDebuggerStatement(JavaScriptParser.DebuggerStatementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"DebuggerStatement",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDebuggerStatement(JavaScriptParser.DebuggerStatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"FunctionDeclaration",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_fd= count_fd + 1;
        createSubTree(index_top,terminal_top,list,count_fd,"FunctionDeclaration");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterClassDeclaration(JavaScriptParser.ClassDeclarationContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ClassDeclaration",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitClassDeclaration(JavaScriptParser.ClassDeclarationContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterClassTail(JavaScriptParser.ClassTailContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ClassTail",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitClassTail(JavaScriptParser.ClassTailContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterClassElement(JavaScriptParser.ClassElementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ClassElement",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitClassElement(JavaScriptParser.ClassElementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMethodDefinition(JavaScriptParser.MethodDefinitionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"MethodDefinition",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMethodDefinition(JavaScriptParser.MethodDefinitionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_i = count_i + 1;
        createSubTree(index_top,terminal_top,list,count_i,"Initialiser");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFormalParameterList(JavaScriptParser.FormalParameterListContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"FormalParameterList",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFormalParameterList(JavaScriptParser.FormalParameterListContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_pl = count_pl + 1;
        createSubTree(index_top,terminal_top,list,count_pl,"ParameterList");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFormalParameterArg(JavaScriptParser.FormalParameterArgContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"FormalParameterArg",id);
        formalparameterarg += 1;

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFormalParameterArg(JavaScriptParser.FormalParameterArgContext ctx) {
        formalparameterarg -= 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterLastFormalParameterArg(JavaScriptParser.LastFormalParameterArgContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"LastFormalParameterArg",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitLastFormalParameterArg(JavaScriptParser.LastFormalParameterArgContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunctionBody(JavaScriptParser.FunctionBodyContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"FunctionBody",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunctionBody(JavaScriptParser.FunctionBodyContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_fb = count_fb + 1;
        createSubTree(index_top,terminal_top,list,count_fb,"FunctionBody");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterSourceElements(JavaScriptParser.SourceElementsContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"SourceElements",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitSourceElements(JavaScriptParser.SourceElementsContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_sele = count_sele + 1;
        createSubTree(index_top,terminal_top,list,count_sele,"SourceElement");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArrayLiteral(JavaScriptParser.ArrayLiteralContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ArrayLiteral",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArrayLiteral(JavaScriptParser.ArrayLiteralContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_al = count_al + 1;
        createSubTree(index_top,terminal_top,list,count_al,"ArrayLiteral");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterElementList(JavaScriptParser.ElementListContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ElementList",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitElementList(JavaScriptParser.ElementListContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_el = count_el + 1;
        createSubTree(index_top,terminal_top,list,count_el,"ElementList");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArrayElement(JavaScriptParser.ArrayElementContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ArrayElement",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArrayElement(JavaScriptParser.ArrayElementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPropertyExpressionAssignment(JavaScriptParser.PropertyExpressionAssignmentContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"PropertyExpressionAssignment",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPropertyExpressionAssignment(JavaScriptParser.PropertyExpressionAssignmentContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_pea = count_pea + 1;
        createSubTree(index_top,terminal_top,list,count_pea,"PropertyExpressionAssignment");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterComputedPropertyExpressionAssignment(JavaScriptParser.ComputedPropertyExpressionAssignmentContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ComputedPropertyExpressionAssignment",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitComputedPropertyExpressionAssignment(JavaScriptParser.ComputedPropertyExpressionAssignmentContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunctionProperty(JavaScriptParser.FunctionPropertyContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"FunctionProperty",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunctionProperty(JavaScriptParser.FunctionPropertyContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPropertyGetter(JavaScriptParser.PropertyGetterContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"PropertyGetter",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPropertyGetter(JavaScriptParser.PropertyGetterContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_get = count_get + 1;
        createSubTree(index_top,terminal_top,list,count_get,"PropertyGetter");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPropertySetter(JavaScriptParser.PropertySetterContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"PropertySetter",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPropertySetter(JavaScriptParser.PropertySetterContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_set = count_set + 1;
        createSubTree(index_top,terminal_top,list,count_set,"PropertySetter");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPropertyShorthand(JavaScriptParser.PropertyShorthandContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"PropertyShorthand",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPropertyShorthand(JavaScriptParser.PropertyShorthandContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPropertyName(JavaScriptParser.PropertyNameContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"PropertyName",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPropertyName(JavaScriptParser.PropertyNameContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_pm = count_pm + 1;
        createSubTree(index_top,terminal_top,list,count_pm,"PropertyName");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArguments(JavaScriptParser.ArgumentsContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Arguments",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArguments(JavaScriptParser.ArgumentsContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_arg = count_arg + 1;
        createSubTree(index_top,terminal_top,list,count_arg,"Arguments");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArgument(JavaScriptParser.ArgumentContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Argument",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArgument(JavaScriptParser.ArgumentContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_arg = count_arg + 1;
        createSubTree(index_top,terminal_top,list,count_arg,"Arguments");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpressionSequence(JavaScriptParser.ExpressionSequenceContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ExpressionSequence",id);
        expression_seq += 1;

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpressionSequence(JavaScriptParser.ExpressionSequenceContext ctx) {
        expression_seq -= 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTemplateStringExpression(JavaScriptParser.TemplateStringExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"TemplateStringExpression",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTemplateStringExpression(JavaScriptParser.TemplateStringExpressionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTernaryExpression(JavaScriptParser.TernaryExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"TernaryExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTernaryExpression(JavaScriptParser.TernaryExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterLogicalAndExpression(JavaScriptParser.LogicalAndExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"LogicalAndExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitLogicalAndExpression(JavaScriptParser.LogicalAndExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPowerExpression(JavaScriptParser.PowerExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"PowerExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPowerExpression(JavaScriptParser.PowerExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPreIncrementExpression(JavaScriptParser.PreIncrementExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"PreIncrementExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPreIncrementExpression(JavaScriptParser.PreIncrementExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterObjectLiteralExpression(JavaScriptParser.ObjectLiteralExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ObjectLiteralExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitObjectLiteralExpression(JavaScriptParser.ObjectLiteralExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMetaExpression(JavaScriptParser.MetaExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"MetaExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMetaExpression(JavaScriptParser.MetaExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterInExpression(JavaScriptParser.InExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"InExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitInExpression(JavaScriptParser.InExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterLogicalOrExpression(JavaScriptParser.LogicalOrExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"LogicalOrExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitLogicalOrExpression(JavaScriptParser.LogicalOrExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterNotExpression(JavaScriptParser.NotExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"NotExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitNotExpression(JavaScriptParser.NotExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPreDecreaseExpression(JavaScriptParser.PreDecreaseExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"PreDecreaseExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPreDecreaseExpression(JavaScriptParser.PreDecreaseExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ArgumentsExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAwaitExpression(JavaScriptParser.AwaitExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"AwaitExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAwaitExpression(JavaScriptParser.AwaitExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterThisExpression(JavaScriptParser.ThisExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ThisExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitThisExpression(JavaScriptParser.ThisExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunctionExpression(JavaScriptParser.FunctionExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"FunctionExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunctionExpression(JavaScriptParser.FunctionExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterUnaryMinusExpression(JavaScriptParser.UnaryMinusExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"UnaryMinusExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitUnaryMinusExpression(JavaScriptParser.UnaryMinusExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAssignmentExpression(JavaScriptParser.AssignmentExpressionContext ctx) {
        expression += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"AssignmentExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAssignmentExpression(JavaScriptParser.AssignmentExpressionContext ctx) {
        expression -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPostDecreaseExpression(JavaScriptParser.PostDecreaseExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"PostDecreaseExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPostDecreaseExpression(JavaScriptParser.PostDecreaseExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTypeofExpression(JavaScriptParser.TypeofExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"TypeofExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTypeofExpression(JavaScriptParser.TypeofExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterInstanceofExpression(JavaScriptParser.InstanceofExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"InstanceofExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitInstanceofExpression(JavaScriptParser.InstanceofExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterUnaryPlusExpression(JavaScriptParser.UnaryPlusExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"UnaryPlusExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitUnaryPlusExpression(JavaScriptParser.UnaryPlusExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDeleteExpression(JavaScriptParser.DeleteExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"DeleteExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDeleteExpression(JavaScriptParser.DeleteExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterImportExpression(JavaScriptParser.ImportExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ImportExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitImportExpression(JavaScriptParser.ImportExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEqualityExpression(JavaScriptParser.EqualityExpressionContext ctx) {
        expression += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"EqualityExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEqualityExpression(JavaScriptParser.EqualityExpressionContext ctx) {
        expression -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBitXOrExpression(JavaScriptParser.BitXOrExpressionContext ctx) {
        expression += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"BitXOrExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBitXOrExpression(JavaScriptParser.BitXOrExpressionContext ctx) {
        expression -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterSuperExpression(JavaScriptParser.SuperExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"SuperExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitSuperExpression(JavaScriptParser.SuperExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMultiplicativeExpression(JavaScriptParser.MultiplicativeExpressionContext ctx) {
        expression += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"MultiplicativeExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMultiplicativeExpression(JavaScriptParser.MultiplicativeExpressionContext ctx) {
        expression -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBitShiftExpression(JavaScriptParser.BitShiftExpressionContext ctx) {
        expression += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"BitShiftExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBitShiftExpression(JavaScriptParser.BitShiftExpressionContext ctx) {
        expression -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParenthesizedExpression(JavaScriptParser.ParenthesizedExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ParenthesizedExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParenthesizedExpression(JavaScriptParser.ParenthesizedExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAdditiveExpression(JavaScriptParser.AdditiveExpressionContext ctx) {
        expression += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"AdditiveExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAdditiveExpression(JavaScriptParser.AdditiveExpressionContext ctx) {
        expression -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterRelationalExpression(JavaScriptParser.RelationalExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"RelationalExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitRelationalExpression(JavaScriptParser.RelationalExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPostIncrementExpression(JavaScriptParser.PostIncrementExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"PostIncrementExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPostIncrementExpression(JavaScriptParser.PostIncrementExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterYieldExpression(JavaScriptParser.YieldExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"YieldExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitYieldExpression(JavaScriptParser.YieldExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBitNotExpression(JavaScriptParser.BitNotExpressionContext ctx) {
        expression += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"BitNotExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBitNotExpression(JavaScriptParser.BitNotExpressionContext ctx) {
        expression -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterNewExpression(JavaScriptParser.NewExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"NewExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitNewExpression(JavaScriptParser.NewExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterLiteralExpression(JavaScriptParser.LiteralExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"LiteralExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitLiteralExpression(JavaScriptParser.LiteralExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArrayLiteralExpression(JavaScriptParser.ArrayLiteralExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ArrayLiteralExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArrayLiteralExpression(JavaScriptParser.ArrayLiteralExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMemberDotExpression(JavaScriptParser.MemberDotExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"MemberDotExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMemberDotExpression(JavaScriptParser.MemberDotExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterClassExpression(JavaScriptParser.ClassExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ClassExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitClassExpression(JavaScriptParser.ClassExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMemberIndexExpression(JavaScriptParser.MemberIndexExpressionContext ctx) {
        memberindex += 2;
        expression_seq += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"MemberIndexExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMemberIndexExpression(JavaScriptParser.MemberIndexExpressionContext ctx) {
        memberindex -= 2;
        expression_seq -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterIdentifierExpression(JavaScriptParser.IdentifierExpressionContext ctx) {
        identifier += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"IdentifierExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIdentifierExpression(JavaScriptParser.IdentifierExpressionContext ctx) {
        identifier -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBitAndExpression(JavaScriptParser.BitAndExpressionContext ctx) {
        expression += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"BitAndExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBitAndExpression(JavaScriptParser.BitAndExpressionContext ctx) {
        expression -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBitOrExpression(JavaScriptParser.BitOrExpressionContext ctx) {
        expression += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"BitOrExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBitOrExpression(JavaScriptParser.BitOrExpressionContext ctx) {
        expression -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAssignmentOperatorExpression(JavaScriptParser.AssignmentOperatorExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"AssignmentOperatorExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAssignmentOperatorExpression(JavaScriptParser.AssignmentOperatorExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVoidExpression(JavaScriptParser.VoidExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"VoidExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVoidExpression(JavaScriptParser.VoidExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCoalesceExpression(JavaScriptParser.CoalesceExpressionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"CoalesceExpression",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCoalesceExpression(JavaScriptParser.CoalesceExpressionContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_expression = count_expression + 1;
        createSubTree(index_top,terminal_top,list,count_expression,"Expression");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAssignable(JavaScriptParser.AssignableContext ctx) {
        assign += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"Assignable",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAssignable(JavaScriptParser.AssignableContext ctx) {assign += 1; }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterObjectLiteral(JavaScriptParser.ObjectLiteralContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ObjectLiteral",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitObjectLiteral(JavaScriptParser.ObjectLiteralContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_ol = count_ol + 1;
        createSubTree(index_top,terminal_top,list,count_ol,"ObjectLiteral");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunctionDecl(JavaScriptParser.FunctionDeclContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"FunctionDecl",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunctionDecl(JavaScriptParser.FunctionDeclContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAnoymousFunctionDecl(JavaScriptParser.AnoymousFunctionDeclContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"AnoymousFunctionDecl",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAnoymousFunctionDecl(JavaScriptParser.AnoymousFunctionDeclContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArrowFunction(JavaScriptParser.ArrowFunctionContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ArrowFunction",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArrowFunction(JavaScriptParser.ArrowFunctionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArrowFunctionParameters(JavaScriptParser.ArrowFunctionParametersContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ArrowFunctionParameters",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArrowFunctionParameters(JavaScriptParser.ArrowFunctionParametersContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterArrowFunctionBody(JavaScriptParser.ArrowFunctionBodyContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ArrowFunctionBody",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitArrowFunctionBody(JavaScriptParser.ArrowFunctionBodyContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAssignmentOperator(JavaScriptParser.AssignmentOperatorContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"AssignmentOperator",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAssignmentOperator(JavaScriptParser.AssignmentOperatorContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_assign = count_assign + 1;
        createSubTree(index_top,terminal_top,list,count_assign,"AssignmentOperator");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterLiteral(JavaScriptParser.LiteralContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Literal",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitLiteral(JavaScriptParser.LiteralContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_literal = count_literal + 1;
        createSubTree(index_top,terminal_top,list,count_literal,"Literal");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterNumericLiteral(JavaScriptParser.NumericLiteralContext ctx) {
        numeric += 1;
        add_Node_node(ctx.getSourceInterval().toString(),"NumericLiteral",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitNumericLiteral(JavaScriptParser.NumericLiteralContext ctx) {
        numeric -= 1;
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_literal = count_literal + 1;
        createSubTree(index_top,terminal_top,list,count_literal,"Literal");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBigintLiteral(JavaScriptParser.BigintLiteralContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"BigintLiteral",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBigintLiteral(JavaScriptParser.BigintLiteralContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterGetter(JavaScriptParser.GetterContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Getter",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitGetter(JavaScriptParser.GetterContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterSetter(JavaScriptParser.SetterContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Setter",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitSetter(JavaScriptParser.SetterContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterIdentifierName(JavaScriptParser.IdentifierNameContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"IdentifierName",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIdentifierName(JavaScriptParser.IdentifierNameContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_id = count_id + 1;
        createSubTree(index_top,terminal_top,list,count_id,"IdentifierName");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterIdentifier(JavaScriptParser.IdentifierContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Identifier",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIdentifier(JavaScriptParser.IdentifierContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterReservedWord(JavaScriptParser.ReservedWordContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"ReservedWord",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitReservedWord(JavaScriptParser.ReservedWordContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_rw = count_rw + 1;
        createSubTree(index_top,terminal_top,list,count_rw,"ReservedWord");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterKeyword(JavaScriptParser.KeywordContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Keyword",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitKeyword(JavaScriptParser.KeywordContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_key = count_key + 1;
        createSubTree(index_top,terminal_top,list,count_key,"Keyword");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterLet(JavaScriptParser.LetContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Let",id);

        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitLet(JavaScriptParser.LetContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEos(JavaScriptParser.EosContext ctx) {
        add_Node_node(ctx.getSourceInterval().toString(),"Eos",id);
        index_stack.push(list.size()-1);
        index_terminal.push(terminal_list.size());
        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEos(JavaScriptParser.EosContext ctx) {
        int index_top = index_stack.pop();
        int terminal_top = index_terminal.pop();
        count_eos = count_eos + 1;
        createSubTree(index_top,terminal_top,list,count_eos,"Eos");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) {
//        add_Node_node(ctx.getSourceInterval().toString(),"EveryRule",id);
//
//        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) {
        String type_ = node.getText();
        terminal_list.add(node.getText());
        if(numeric > 0){
            return ;
        }
        if(type_.startsWith("\"")||type_.startsWith("\'")){
            add_Node_node(node.getSourceInterval().toString(),"StringLiteral",id);
            id += 1;
            return ;
        }
        if(map.containsKey(type_)){
            add_Node_node(node.getSourceInterval().toString(),type_,id);
            if(type_ == "function"){
                map.put("function",map.get("function")+1);
            }else if(type_ == "("&&map.get("function") > 0){
                map.put("function",map.get("function")-1);
            }
            id += 1;
            return ;
        }
        if(map.get("function")==1){
            add_Node_node(node.getSourceInterval().toString(),"function_name",id);
            map.put("function",0);id += 1;
        }else if(expression > 0&& identifier > 0&&memberindex > 0&&expression_seq==memberindex){
            add_Node_node(node.getSourceInterval().toString(),"array_name",id);id += 1;
        }else if(expression > 0&& identifier > 0&&memberindex > 0&&expression_seq > memberindex) {
            add_Node_node(node.getSourceInterval().toString(),"index_para",id);id += 1;
        }else if(variable_decl > 0&&assign > 0){
            add_Node_node(node.getSourceInterval().toString(),"variable_name",id);id += 1;
        }else if(formalparameterarg > 0&&assign > 0){
            add_Node_node(node.getSourceInterval().toString(),"formalparameter",id);id += 1;
        }else if(expression > 0&& identifier > 0){
            add_Node_node(node.getSourceInterval().toString(),"expression_para",id);id += 1;
        }


//        add_Node_node(node.getSourceInterval().toString(),node.getText(),id);

//        id += 1;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node) {
        if(node.getText()!="<EOF>")
            terminal_list.add(node.getText());
    }
}
