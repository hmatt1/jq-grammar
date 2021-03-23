package com.jq;

import com.jq.JqParser.JqLexer;
import com.jq.JqParser.JqParser;
import com.jq.util.EvalVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

public class JqTest {
    @Test
    void expressionTest() {
        String expr = "1";
        JqLexer jqLexer = new JqLexer(CharStreams.fromString(
                expr));
        JqParser jqParser = new JqParser(new CommonTokenStream(jqLexer));

        JqParser.EvalContext evalContext = jqParser.eval();

        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(evalContext);
    }
}
