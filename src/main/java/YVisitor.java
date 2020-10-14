import java.util.ArrayList;

public class YVisitor extends JavaScriptParserBaseVisitor {
    public static int id = 0;
    class Node{
        String interval;
        int id;
        String type_;
    };
    ArrayList<YVisitor.Node> list = new ArrayList<>();
    @Override public Object  visitProgram(JavaScriptParser.ProgramContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "program";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitProgram(ctx);
    }

    @Override public Object  visitSourceElements(JavaScriptParser.SourceElementsContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "SourceElements";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitSourceElements(ctx);
    }

    @Override public Object  visitSourceElement(JavaScriptParser.SourceElementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "SourceElement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitSourceElement(ctx);
    }

    @Override public Object  visitStatement(JavaScriptParser.StatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "SourceElement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitStatement(ctx);
    }

    @Override public Object  visitBlock(JavaScriptParser.BlockContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "Block";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitBlock(ctx);
    }

    @Override public Object  visitStatementList(JavaScriptParser.StatementListContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "StatementList";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitStatementList(ctx);
    }

    @Override public Object visitVariableStatement(JavaScriptParser.VariableStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "VariableStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitVariableStatement(ctx);
    }

    @Override public Object visitVariableDeclarationList(JavaScriptParser.VariableDeclarationListContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "VariableDeclarationList";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitVariableDeclarationList(ctx);
    }

    @Override public Object visitVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "VariableDeclaration";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitVariableDeclaration(ctx);
    }


    @Override public Object visitEmptyStatement(JavaScriptParser.EmptyStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "EmptyStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitEmptyStatement(ctx);
    }

    @Override public Object visitExpressionStatement(JavaScriptParser.ExpressionStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ExpressionStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitExpressionStatement(ctx);
    }

    @Override public Object visitIfStatement(JavaScriptParser.IfStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "IfStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitIfStatement(ctx);
    }

    @Override public Object visitDoStatement(JavaScriptParser.DoStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "DoStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitDoStatement(ctx);
    }

    @Override public Object visitWhileStatement(JavaScriptParser.WhileStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "WhileStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitWhileStatement(ctx);
    }

    @Override public Object visitForStatement(JavaScriptParser.ForStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        System.out.println(ctx.getText());
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ForStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitForStatement(ctx);
    }


    @Override public Object visitForInStatement(JavaScriptParser.ForInStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ForInStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitForInStatement(ctx);
    }


    @Override public Object visitContinueStatement(JavaScriptParser.ContinueStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ContinueStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitContinueStatement(ctx);
    }

    @Override public Object visitBreakStatement(JavaScriptParser.BreakStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "BreakStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitBreakStatement(ctx);
    }

    @Override public Object visitReturnStatement(JavaScriptParser.ReturnStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ReturnStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitReturnStatement(ctx);
    }

    @Override public Object visitWithStatement(JavaScriptParser.WithStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "WithStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitWithStatement(ctx);
    }

    @Override public Object visitSwitchStatement(JavaScriptParser.SwitchStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "SwitchStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitSwitchStatement(ctx);
    }

    @Override public Object visitCaseBlock(JavaScriptParser.CaseBlockContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "CaseBlock";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitCaseBlock(ctx);
    }

    @Override public Object visitCaseClauses(JavaScriptParser.CaseClausesContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "CaseClauses";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitCaseClauses(ctx);
    }

    @Override public Object visitCaseClause(JavaScriptParser.CaseClauseContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "CaseClause";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitCaseClause(ctx);
    }

    @Override public Object visitDefaultClause(JavaScriptParser.DefaultClauseContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "DefaultClause";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitDefaultClause(ctx);
    }

    @Override public Object visitLabelledStatement(JavaScriptParser.LabelledStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "LabelledStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitLabelledStatement(ctx);
    }

    @Override public Object visitThrowStatement(JavaScriptParser.ThrowStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ThrowStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitThrowStatement(ctx);
    }

    @Override public Object visitTryStatement(JavaScriptParser.TryStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "TryStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitTryStatement(ctx);
    }

    @Override public Object visitCatchProduction(JavaScriptParser.CatchProductionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "CatchProduction";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitCatchProduction(ctx);
    }

    @Override public Object visitFinallyProduction(JavaScriptParser.FinallyProductionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "FinallyProduction";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitFinallyProduction(ctx);
    }

    @Override public Object visitDebuggerStatement(JavaScriptParser.DebuggerStatementContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "DebuggerStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitDebuggerStatement(ctx);
    }

    @Override public Object visitFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "FunctionDeclaration";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitFunctionDeclaration(ctx);
    }

    @Override public Object visitFormalParameterList(JavaScriptParser.FormalParameterListContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "FormalParameterList";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitFormalParameterList(ctx);
    }

    @Override public Object visitFunctionBody(JavaScriptParser.FunctionBodyContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "FunctionBody";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitFunctionBody(ctx);
    }

    @Override public Object visitArrayLiteral(JavaScriptParser.ArrayLiteralContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ArrayLiteral";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitArrayLiteral(ctx);
    }

    @Override public Object visitElementList(JavaScriptParser.ElementListContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ElementList";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitElementList(ctx);
    }

    @Override public Object visitObjectLiteral(JavaScriptParser.ObjectLiteralContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ObjectLiteral";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitObjectLiteral(ctx);
    }


    @Override public Object visitPropertyExpressionAssignment(JavaScriptParser.PropertyExpressionAssignmentContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "PropertyExpressionAssignment";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitPropertyExpressionAssignment(ctx);
    }

    @Override public Object visitPropertyGetter(JavaScriptParser.PropertyGetterContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "PropertyGetter";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitPropertyGetter(ctx);
    }

    @Override public Object visitPropertySetter(JavaScriptParser.PropertySetterContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "PropertySetter";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitPropertySetter(ctx);
    }

    @Override public Object visitPropertyName(JavaScriptParser.PropertyNameContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "PropertyName";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitPropertyName(ctx);
    }


    @Override public Object visitArguments(JavaScriptParser.ArgumentsContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "Arguments";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitArguments(ctx);
    }


    @Override public Object visitExpressionSequence(JavaScriptParser.ExpressionSequenceContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ExpressionSequence";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitExpressionSequence(ctx);
    }

    @Override public Object visitTernaryExpression(JavaScriptParser.TernaryExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "TernaryExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitTernaryExpression(ctx);
    }

    @Override public Object visitLogicalAndExpression(JavaScriptParser.LogicalAndExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "LogicalAndExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitLogicalAndExpression(ctx);
    }

    @Override public Object visitPreIncrementExpression(JavaScriptParser.PreIncrementExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "PreIncrementExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitPreIncrementExpression(ctx);
    }

    @Override public Object visitObjectLiteralExpression(JavaScriptParser.ObjectLiteralExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ObjectLiteralExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitObjectLiteralExpression(ctx);
    }

    @Override public Object visitInExpression(JavaScriptParser.InExpressionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "InExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitInExpression(ctx);
    }

    @Override public Object visitLogicalOrExpression(JavaScriptParser.LogicalOrExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "LogicalOrExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitLogicalOrExpression(ctx);
    }

    @Override public Object visitNotExpression(JavaScriptParser.NotExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "NotExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitNotExpression(ctx);
    }

    @Override public Object visitPreDecreaseExpression(JavaScriptParser.PreDecreaseExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "PreDecreaseExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitPreDecreaseExpression(ctx);
    }

    @Override public Object visitArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ArgumentsExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitArgumentsExpression(ctx);
    }

    @Override public Object visitThisExpression(JavaScriptParser.ThisExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ThisExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitThisExpression(ctx);
    }

    @Override public Object visitFunctionExpression(JavaScriptParser.FunctionExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "FunctionExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitFunctionExpression(ctx);
    }

    @Override public Object visitUnaryMinusExpression(JavaScriptParser.UnaryMinusExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "UnaryMinusExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitUnaryMinusExpression(ctx);
    }

    @Override public Object visitAssignmentExpression(JavaScriptParser.AssignmentExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "AssignmentExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitAssignmentExpression(ctx);
    }

    @Override public Object visitPostDecreaseExpression(JavaScriptParser.PostDecreaseExpressionContext ctx) {         YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "PostDecreaseExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitPostDecreaseExpression(ctx);
    }

    @Override public Object visitTypeofExpression(JavaScriptParser.TypeofExpressionContext ctx) {         YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "TypeofExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitTypeofExpression(ctx);
    }

    @Override public Object visitInstanceofExpression(JavaScriptParser.InstanceofExpressionContext ctx) {         YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "InstanceofExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitInstanceofExpression(ctx);
    }

    @Override public Object visitUnaryPlusExpression(JavaScriptParser.UnaryPlusExpressionContext ctx) {         YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "UnaryPlusExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitUnaryPlusExpression(ctx);
    }

    @Override public Object visitDeleteExpression(JavaScriptParser.DeleteExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "DeleteExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitDeleteExpression(ctx);
    }

    @Override public Object visitEqualityExpression(JavaScriptParser.EqualityExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "EqualityExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitEqualityExpression(ctx);
    }

    @Override public Object visitBitXOrExpression(JavaScriptParser.BitXOrExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "BitXOrExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitBitXOrExpression(ctx);
    }

    @Override public Object visitMultiplicativeExpression(JavaScriptParser.MultiplicativeExpressionContext ctx) {         YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "MultiplicativeExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitMultiplicativeExpression(ctx);
    }

    @Override public Object visitBitShiftExpression(JavaScriptParser.BitShiftExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "BitShiftExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitBitShiftExpression(ctx);
    }

    @Override public Object visitParenthesizedExpression(JavaScriptParser.ParenthesizedExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ParenthesizedExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitParenthesizedExpression(ctx);
    }

    @Override public Object visitAdditiveExpression(JavaScriptParser.AdditiveExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "AdditiveExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitAdditiveExpression(ctx);
    }

    @Override public Object visitRelationalExpression(JavaScriptParser.RelationalExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "RelationalExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitRelationalExpression(ctx);
    }

    @Override public Object visitPostIncrementExpression(JavaScriptParser.PostIncrementExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "PostIncrementExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitPostIncrementExpression(ctx);
    }

    @Override public Object visitBitNotExpression(JavaScriptParser.BitNotExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "BitNotExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitBitNotExpression(ctx);
    }

    @Override public Object visitNewExpression(JavaScriptParser.NewExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "NewExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitNewExpression(ctx);
    }

    @Override public Object visitLiteralExpression(JavaScriptParser.LiteralExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "LiteralExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitLiteralExpression(ctx);
    }

    @Override public Object visitArrayLiteralExpression(JavaScriptParser.ArrayLiteralExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ArrayLiteralExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitArrayLiteralExpression(ctx);
    }

    @Override public Object visitMemberDotExpression(JavaScriptParser.MemberDotExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "MemberDotExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitMemberDotExpression(ctx);
    }

    @Override public Object visitMemberIndexExpression(JavaScriptParser.MemberIndexExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "MemberIndexExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitMemberIndexExpression(ctx);
    }

    @Override public Object visitIdentifierExpression(JavaScriptParser.IdentifierExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "IdentifierExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitIdentifierExpression(ctx);
    }

    @Override public Object visitBitAndExpression(JavaScriptParser.BitAndExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "BitAndExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitBitAndExpression(ctx);
    }

    @Override public Object visitBitOrExpression(JavaScriptParser.BitOrExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "BitOrExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitBitOrExpression(ctx);
    }

    @Override public Object visitAssignmentOperatorExpression(JavaScriptParser.AssignmentOperatorExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "AssignmentOperatorExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitAssignmentOperatorExpression(ctx);
    }

    @Override public Object visitVoidExpression(JavaScriptParser.VoidExpressionContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "VoidExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitVoidExpression(ctx);
    }

    @Override public Object visitAssignmentOperator(JavaScriptParser.AssignmentOperatorContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "AssignmentOperator";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitAssignmentOperator(ctx);
    }

    @Override public Object visitLiteral(JavaScriptParser.LiteralContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "Literal";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitLiteral(ctx);
    }

    @Override public Object visitNumericLiteral(JavaScriptParser.NumericLiteralContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "NumericLiteral";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitNumericLiteral(ctx);
    }

    @Override public Object visitIdentifierName(JavaScriptParser.IdentifierNameContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "IdentifierName";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitIdentifierName(ctx);
    }

    @Override public Object visitReservedWord(JavaScriptParser.ReservedWordContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ReservedWord";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitReservedWord(ctx);
    }

    @Override public Object visitKeyword(JavaScriptParser.KeywordContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "Keyword";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitKeyword(ctx);
    }


    @Override public Object visitGetter(JavaScriptParser.GetterContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "Getter";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitGetter(ctx);
    }

    @Override public Object visitSetter(JavaScriptParser.SetterContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "Setter";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitSetter(ctx);
    }

    @Override public Object visitEos(JavaScriptParser.EosContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "Eos";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitEos(ctx);
    }

//    @Override public Object visitEof(JavaScriptParser.EofContext ctx) {
//        YVisitor.Node node = new YVisitor.Node();
//        node.interval = ctx.getSourceInterval().toString();
//        node.type_ = "Eof";
//        node.id = id;
//        id += 1;
//        list.add(node);
//        return super.visitEof(ctx);
//    }

//    @Override public Object visitProgram(JavaScriptParser.ProgramContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitSourceElement(JavaScriptParser.SourceElementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitStatement(JavaScriptParser.StatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitBlock(JavaScriptParser.BlockContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitStatementList(JavaScriptParser.StatementListContext ctx) { return visitChildren(ctx); }

    @Override public Object visitImportStatement(JavaScriptParser.ImportStatementContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ImportStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitImportStatement(ctx); }

    @Override public Object visitImportFromBlock(JavaScriptParser.ImportFromBlockContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ImportFromBlock";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitImportFromBlock(ctx); }

    @Override public Object visitModuleItems(JavaScriptParser.ModuleItemsContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ModuleItems";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitModuleItems(ctx);}

    @Override public Object visitImportDefault(JavaScriptParser.ImportDefaultContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ImportDefault";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitImportDefault(ctx);}

    @Override public Object visitImportNamespace(JavaScriptParser.ImportNamespaceContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ImportNamespace";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitImportNamespace(ctx); }

    @Override public Object visitImportFrom(JavaScriptParser.ImportFromContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ImportFrom";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitImportFrom(ctx); }

    @Override public Object visitAliasName(JavaScriptParser.AliasNameContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "AliasName";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitAliasName(ctx);}

    @Override public Object visitExportDeclaration(JavaScriptParser.ExportDeclarationContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ExportDeclaration";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitExportDeclaration(ctx); }

    @Override public Object visitExportDefaultDeclaration(JavaScriptParser.ExportDefaultDeclarationContext ctx) {
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ExportDefaultDeclaration";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitExportDefaultDeclaration(ctx);
    }
    @Override public Object visitExportFromBlock(JavaScriptParser.ExportFromBlockContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ExportFromBlock";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitExportFromBlock(ctx); }

    @Override public Object visitDeclaration(JavaScriptParser.DeclarationContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "Declaration";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitDeclaration(ctx); }

//    @Override public Object visitVariableStatement(JavaScriptParser.VariableStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitVariableDeclarationList(JavaScriptParser.VariableDeclarationListContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitEmptyStatement(JavaScriptParser.EmptyStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitExpressionStatement(JavaScriptParser.ExpressionStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitIfStatement(JavaScriptParser.IfStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitDoStatement(JavaScriptParser.DoStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitWhileStatement(JavaScriptParser.WhileStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitForStatement(JavaScriptParser.ForStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitForInStatement(JavaScriptParser.ForInStatementContext ctx) { return visitChildren(ctx); }
//
    @Override public Object visitForOfStatement(JavaScriptParser.ForOfStatementContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ForOfStatement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitForOfStatement(ctx);  }
//
    @Override public Object visitVarModifier(JavaScriptParser.VarModifierContext ctx){
        YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "VarModifier";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitVarModifier(ctx);  }
//
//    @Override public Object visitContinueStatement(JavaScriptParser.ContinueStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitBreakStatement(JavaScriptParser.BreakStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitReturnStatement(JavaScriptParser.ReturnStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitYieldStatement(JavaScriptParser.YieldStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitWithStatement(JavaScriptParser.WithStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitSwitchStatement(JavaScriptParser.SwitchStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitCaseBlock(JavaScriptParser.CaseBlockContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitCaseClauses(JavaScriptParser.CaseClausesContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitCaseClause(JavaScriptParser.CaseClauseContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitDefaultClause(JavaScriptParser.DefaultClauseContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitLabelledStatement(JavaScriptParser.LabelledStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitThrowStatement(JavaScriptParser.ThrowStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitTryStatement(JavaScriptParser.TryStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitCatchProduction(JavaScriptParser.CatchProductionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitFinallyProduction(JavaScriptParser.FinallyProductionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitDebuggerStatement(JavaScriptParser.DebuggerStatementContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) { return visitChildren(ctx); }

    @Override public Object visitClassDeclaration(JavaScriptParser.ClassDeclarationContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ClassDeclaration";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitClassDeclaration(ctx); }

    @Override public Object visitClassTail(JavaScriptParser.ClassTailContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ClassTail";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitClassTail(ctx); }

    @Override public Object visitClassElement(JavaScriptParser.ClassElementContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ClassElement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitClassElement(ctx); }

    @Override public Object visitMethodDefinition(JavaScriptParser.MethodDefinitionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "MethodDefinition";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitMethodDefinition(ctx); }

//    @Override public Object visitFormalParameterList(JavaScriptParser.FormalParameterListContext ctx) { return visitChildren(ctx); }

    @Override public Object visitFormalParameterArg(JavaScriptParser.FormalParameterArgContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "FormalParameterArg";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitFormalParameterArg(ctx); }

    @Override public Object visitLastFormalParameterArg(JavaScriptParser.LastFormalParameterArgContext ctx) {YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "LastFormalParameterArg";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitLastFormalParameterArg(ctx); }

//    @Override public Object visitFunctionBody(JavaScriptParser.FunctionBodyContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitSourceElements(JavaScriptParser.SourceElementsContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitArrayLiteral(JavaScriptParser.ArrayLiteralContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitElementList(JavaScriptParser.ElementListContext ctx) { return visitChildren(ctx); }

    @Override public Object visitArrayElement(JavaScriptParser.ArrayElementContext ctx) {YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ArrayElement";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitArrayElement(ctx); }

//    @Override public Object visitObjectLiteral(JavaScriptParser.ObjectLiteralContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitPropertyExpressionAssignment(JavaScriptParser.PropertyExpressionAssignmentContext ctx) { return visitChildren(ctx); }

    @Override public Object visitComputedPropertyExpressionAssignment(JavaScriptParser.ComputedPropertyExpressionAssignmentContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ComputedPropertyExpressionAssignment";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitComputedPropertyExpressionAssignment(ctx); }

    @Override public Object visitFunctionProperty(JavaScriptParser.FunctionPropertyContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "FunctionProperty";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitFunctionProperty(ctx); }

//    @Override public Object visitPropertyGetter(JavaScriptParser.PropertyGetterContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitPropertySetter(JavaScriptParser.PropertySetterContext ctx) { return visitChildren(ctx); }

    @Override public Object visitPropertyShorthand(JavaScriptParser.PropertyShorthandContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "PropertyShorthand";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitPropertyShorthand(ctx); }

//    @Override public Object visitPropertyName(JavaScriptParser.PropertyNameContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitArguments(JavaScriptParser.ArgumentsContext ctx) { return visitChildren(ctx); }

    @Override public Object visitArgument(JavaScriptParser.ArgumentContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "Argument";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitArgument(ctx); }

//    @Override public Object visitExpressionSequence(JavaScriptParser.ExpressionSequenceContext ctx) { return visitChildren(ctx); }

    @Override public Object visitTemplateStringExpression(JavaScriptParser.TemplateStringExpressionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "TemplateStringExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitTemplateStringExpression(ctx); }

//    @Override public Object visitTernaryExpression(JavaScriptParser.TernaryExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitLogicalAndExpression(JavaScriptParser.LogicalAndExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Object visitPowerExpression(JavaScriptParser.PowerExpressionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "PowerExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitPowerExpression(ctx); }

//    @Override public Object visitPreIncrementExpression(JavaScriptParser.PreIncrementExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitObjectLiteralExpression(JavaScriptParser.ObjectLiteralExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Object visitMetaExpression(JavaScriptParser.MetaExpressionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "MetaExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitMetaExpression(ctx); }

//    @Override public Object visitInExpression(JavaScriptParser.InExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitLogicalOrExpression(JavaScriptParser.LogicalOrExpressionContext ctx) { return visitChildren(ctx); }

//    @Override public Object visitNotExpression(JavaScriptParser.NotExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitPreDecreaseExpression(JavaScriptParser.PreDecreaseExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Object visitAwaitExpression(JavaScriptParser.AwaitExpressionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "AwaitExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitAwaitExpression(ctx); }

//    @Override public Object visitThisExpression(JavaScriptParser.ThisExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitFunctionExpression(JavaScriptParser.FunctionExpressionContext ctx) { return visitChildren(ctx); }

//    @Override public Object visitUnaryMinusExpression(JavaScriptParser.UnaryMinusExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitAssignmentExpression(JavaScriptParser.AssignmentExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitPostDecreaseExpression(JavaScriptParser.PostDecreaseExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitTypeofExpression(JavaScriptParser.TypeofExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitInstanceofExpression(JavaScriptParser.InstanceofExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitUnaryPlusExpression(JavaScriptParser.UnaryPlusExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitDeleteExpression(JavaScriptParser.DeleteExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Object visitImportExpression(JavaScriptParser.ImportExpressionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ImportExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitImportExpression(ctx); }

//    @Override public Object visitEqualityExpression(JavaScriptParser.EqualityExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitBitXOrExpression(JavaScriptParser.BitXOrExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Object visitSuperExpression(JavaScriptParser.SuperExpressionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "SuperExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitSuperExpression(ctx); }

//    @Override public Object visitMultiplicativeExpression(JavaScriptParser.MultiplicativeExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitBitShiftExpression(JavaScriptParser.BitShiftExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitParenthesizedExpression(JavaScriptParser.ParenthesizedExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitAdditiveExpression(JavaScriptParser.AdditiveExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitRelationalExpression(JavaScriptParser.RelationalExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitPostIncrementExpression(JavaScriptParser.PostIncrementExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Object visitYieldExpression(JavaScriptParser.YieldExpressionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "YieldExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitYieldExpression(ctx); }

//    @Override public Object visitBitNotExpression(JavaScriptParser.BitNotExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitNewExpression(JavaScriptParser.NewExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitLiteralExpression(JavaScriptParser.LiteralExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitArrayLiteralExpression(JavaScriptParser.ArrayLiteralExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitMemberDotExpression(JavaScriptParser.MemberDotExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Object visitClassExpression(JavaScriptParser.ClassExpressionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ClassExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitClassExpression(ctx); }

//    @Override public Object visitMemberIndexExpression(JavaScriptParser.MemberIndexExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitIdentifierExpression(JavaScriptParser.IdentifierExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitBitAndExpression(JavaScriptParser.BitAndExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitBitOrExpression(JavaScriptParser.BitOrExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitAssignmentOperatorExpression(JavaScriptParser.AssignmentOperatorExpressionContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitVoidExpression(JavaScriptParser.VoidExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Object visitCoalesceExpression(JavaScriptParser.CoalesceExpressionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "CoalesceExpression";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitCoalesceExpression(ctx); }

    @Override public Object visitAssignable(JavaScriptParser.AssignableContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "Assignable";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitAssignable(ctx); }

    @Override public Object visitFunctionDecl(JavaScriptParser.FunctionDeclContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "FunctionDecl";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitFunctionDecl(ctx); }

    @Override public Object visitAnoymousFunctionDecl(JavaScriptParser.AnoymousFunctionDeclContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "AnoymousFunctionDecl";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitAnoymousFunctionDecl(ctx);}

    @Override public Object visitArrowFunction(JavaScriptParser.ArrowFunctionContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ArrowFunction";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitArrowFunction(ctx); }

    @Override public Object visitArrowFunctionParameters(JavaScriptParser.ArrowFunctionParametersContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ArrowFunctionParameters";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitArrowFunctionParameters(ctx); }

    @Override public Object visitArrowFunctionBody(JavaScriptParser.ArrowFunctionBodyContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "ArrowFunctionBody";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitArrowFunctionBody(ctx); }

//    @Override public Object visitAssignmentOperator(JavaScriptParser.AssignmentOperatorContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitLiteral(JavaScriptParser.LiteralContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitNumericLiteral(JavaScriptParser.NumericLiteralContext ctx) { return visitChildren(ctx); }

    @Override public Object visitBigintLiteral(JavaScriptParser.BigintLiteralContext ctx) { YVisitor.Node node = new YVisitor.Node();
        node.interval = ctx.getSourceInterval().toString();
        node.type_ = "BigintLiteral";
        node.id = id;
        id += 1;
        list.add(node);
        return super.visitBigintLiteral(ctx); }

//    @Override public Object visitIdentifierName(JavaScriptParser.IdentifierNameContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitReservedWord(JavaScriptParser.ReservedWordContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitKeyword(JavaScriptParser.KeywordContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitGetter(JavaScriptParser.GetterContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitSetter(JavaScriptParser.SetterContext ctx) { return visitChildren(ctx); }
//
//    @Override public Object visitEos(JavaScriptParser.EosContext ctx) { return visitChildren(ctx); }

}
