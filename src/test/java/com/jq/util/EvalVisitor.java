package com.jq.util;

import com.jq.JqParser.JqBaseVisitor;
import com.jq.JqParser.JqParser;

public class EvalVisitor extends JqBaseVisitor<Number> {

    @Override
    public Number visitEval(JqParser.EvalContext ctx) {
        System.out.println("Eval:" + ctx.getText());
        return super.visitEval(ctx);
    }
}