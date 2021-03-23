package com.jq;

import com.jq.JqParser.JqLexer;
import com.jq.JqParser.JqParser;
import com.jq.util.ExpVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class JqTest {
    private static final Logger log = LoggerFactory.getLogger(JqTest.class);

    @ParameterizedTest
    @ValueSource(strings = {
            ".",
            ".foo",
            ".foo.bar"
    })
    void expressionTest(String expr) {
        log.info(() -> "Evaluating expression: " + expr);

        JqLexer jqLexer = new JqLexer(CharStreams.fromString(
                expr));
        JqParser jqParser = new JqParser(new CommonTokenStream(jqLexer));

        JqParser.ExpContext expContext = jqParser.exp();

        ExpVisitor visitor = new ExpVisitor();
        visitor.visit(expContext);
    }
}
