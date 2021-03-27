package com.jq.util;

import com.jq.JqParser.JqBaseVisitor;
import com.jq.JqParser.JqParser;
import org.antlr.v4.runtime.tree.ErrorNode;

public class TopVisitor extends JqBaseVisitor<Object> {
    @Override
    public Object visitVPipe(JqParser.VPipeContext ctx) {
        System.out.println("vPipe:" + ctx.getText());
        return super.visitVPipe(ctx);
    }

    @Override
    public Object visitVArrPipe(JqParser.VArrPipeContext ctx) {
        System.out.println("vArrPipe:" + ctx.getText());
        return super.visitVArrPipe(ctx);
    }

    @Override
    public Object visitVValuePipe(JqParser.VValuePipeContext ctx) {
        System.out.println("vValuePipe:" + ctx.getText());
        return super.visitVValuePipe(ctx);
    }

    @Override
    public Object visitVValue(JqParser.VValueContext ctx) {
        System.out.println("vValue:" + ctx.getText());
        return super.visitVValue(ctx);
    }

    @Override
    public Object visitVTermListFilter(JqParser.VTermListFilterContext ctx) {
        System.out.println("vTermListFilter:" + ctx.getText());
        return super.visitVTermListFilter(ctx);
    }

    @Override
    public Object visitVJson(JqParser.VJsonContext ctx) {
        System.out.println("vJson:" + ctx.getText());
        return super.visitVJson(ctx);
    }

    @Override
    public Object visitVArr(JqParser.VArrContext ctx) {
        System.out.println("vArr:" + ctx.getText());
        return super.visitVArr(ctx);
    }

    @Override
    public Object visitVTermList(JqParser.VTermListContext ctx) {
        System.out.println("vTermList:" + ctx.getText());
        return super.visitVTermList(ctx);
    }

    @Override
    public Object visitVKeyword(JqParser.VKeywordContext ctx) {
        System.out.println("vKeyword:" + ctx.getText());
        return super.visitVKeyword(ctx);
    }

    @Override
    public Object visitVFunction(JqParser.VFunctionContext ctx) {
        System.out.println("vFunction:" + ctx.getText());
        return super.visitVFunction(ctx);
    }

    @Override
    public Object visitFunction(JqParser.FunctionContext ctx) {
        System.out.println("function:" + ctx.getText());
        return super.visitFunction(ctx);
    }

    @Override
    public Object visitArgs(JqParser.ArgsContext ctx) {
        System.out.println("args:" + ctx.getText());
        return super.visitArgs(ctx);
    }

    @Override
    public Object visitJson(JqParser.JsonContext ctx) {
        System.out.println("Json:" + ctx.getText());
        return super.visitJson(ctx);
    }

    @Override
    public Object visitPair(JqParser.PairContext ctx) {
        System.out.println("Pair:" + ctx.getText());
        return super.visitPair(ctx);
    }

    @Override
    public Object visitArr(JqParser.ArrContext ctx) {
        System.out.println("Arr:" + ctx.getText());
        return super.visitArr(ctx);
    }

    @Override
    public Object visitExp(JqParser.ExpContext ctx) {
        System.out.println("Exp:" + ctx.getText());
        return super.visitExp(ctx);
    }

    @Override
    public Object visitTerm_list(JqParser.Term_listContext ctx) {
        System.out.println("Term List:" + ctx.getText());
        return super.visitTerm_list(ctx);
    }

    @Override
    public Object visitTerm(JqParser.TermContext ctx) {
        System.out.println("Term:" + ctx.getText());
        return super.visitTerm(ctx);
    }

    @Override
    public Object visitKeyword(JqParser.KeywordContext ctx) {
        System.out.println("Keyword:" + ctx.getText());
        return super.visitKeyword(ctx);
    }


    @Override
    public Object visitErrorNode(ErrorNode node) {
        throw new RuntimeException(node.getText());
    }
}