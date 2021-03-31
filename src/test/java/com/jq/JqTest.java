package com.jq;

import com.jq.JqParser.JqLexer;
import com.jq.JqParser.JqParser;
import com.jq.util.TopVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JqTest {
    private static final Logger log = LoggerFactory.getLogger(JqTest.class);

    @ParameterizedTest
    @ValueSource(strings = {
            "myfunc()",
            "{\"foo\": 1}",
            ". as $a // [$a, {$b}, $e]? // $f | [$a, $b]",
            "a // b // c",
            ".foo?",
            ".",
            ".foo",
            ".foo.bar",
            ".[]",
            ".[] | {test: .foo}",
            "[.[] | {message: .commit.message, name: .commit.committer.name}]",
            "[.[] | tojson | fromjson]",
            "{\"a\":1, \"b\":2, \"c\":3, \"d\":\"c\"}",
            "[1,null,[],[1,[2,[[3]]]],[{}],[{\"a\":[1,[2]]}]]",
            ".[-2] = 5",
            "[[\"a\",\"b\"],1,[\"a\",\"b\"],\"a\",\"b\",2,3]",
            "flatten(3,2,1)",
            ".[2:4] = ([], [\"a\",\"b\"], [\"a\",\"b\",\"c\"])",
            "{$a}",
            ".[] | . as {$a}",
            ".[] | . as {$a, b: [$c, {$d}]} ?// [$a, {$b}, $e] ?// $f | [$a, $b, $c, $d, $e, $f]",
            ". as {$a, b: [$c, {$d}]} ?",
            "[{\"a\":{\"old\":1, \"new\":2},\"b\":2}]",
            "false"
    })
    void expressionTest(String expr) {
        log.info(() -> "Evaluating expression: " + expr);

        JqLexer jqLexer = new JqLexer(CharStreams.fromString(
                expr));
        JqParser jqParser = new JqParser(new CommonTokenStream(jqLexer));

        JqParser.TopContext expContext = jqParser.top();

        TopVisitor visitor = new TopVisitor();
        assertDoesNotThrow(() -> {
            visitor.visit(expContext);
        });

        assertThat(expContext.getText().replaceAll("\\s+","")).isEqualTo(expr.replaceAll("\\s+",""));
    }

    @ParameterizedTest
    @CsvFileSource(files = "./src/test/resources/jq-tests.csv", numLinesToSkip = 1)
    void jqTests(String program, String input, String output) {
        // tests came from https://raw.githubusercontent.com/stedolan/jq/master/tests/jq.test
        log.info(() -> "Evaluating expression: " + program);

        if (!program.contains("%%FAIL")) {
            JqLexer jqLexer = new JqLexer(CharStreams.fromString(
                    program));
            JqParser jqParser = new JqParser(new CommonTokenStream(jqLexer));

            JqParser.TopContext expContext = jqParser.top();

            TopVisitor visitor = new TopVisitor();
            assertDoesNotThrow(() -> {
                visitor.visit(expContext);
            });
            assertThat(expContext.getText().replaceAll("\\s+","")).isEqualTo(program.replaceAll("\\s+",""));
        } else {
            // skip over failure scenarios
            assertThat(program).contains("FAIL");
        }
    }
}
