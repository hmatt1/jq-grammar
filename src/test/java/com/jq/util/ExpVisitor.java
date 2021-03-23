package com.jq.util;

import com.jq.JqParser.JqBaseVisitor;
import com.jq.JqParser.JqParser;

public class ExpVisitor extends JqBaseVisitor<Number> {

    @Override
    public Number visitExp(JqParser.ExpContext ctx) {
        System.out.println("Exp:" + ctx.getText());
        return super.visitExp(ctx);
    }

    @Override
    public Number visitTerm_list(JqParser.Term_listContext ctx) {
        System.out.println("Term List:" + ctx.getText());
        return super.visitTerm_list(ctx);
    }

    @Override
    public Number visitTerm(JqParser.TermContext ctx) {
        System.out.println("Term:" + ctx.getText());
        return super.visitTerm(ctx);
    }
}