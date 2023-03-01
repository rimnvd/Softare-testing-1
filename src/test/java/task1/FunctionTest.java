package task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {

    @ParameterizedTest
    @MethodSource("provideArgsForArctg")
    void positiveArgsCheck(double x, double expected) {
        assertEquals(expected, Function.arctg(x), 0.00001);
    }

    @ParameterizedTest
    @MethodSource("provideArgsForArctg")
    void negativeArgsCheck(double x, double expected) {
        assertEquals(-expected, Function.arctg(-x),  0.00001);
    }

    private static Stream<Arguments> provideArgsForArctg() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1.001, Double.NaN),
                Arguments.of(Math.sqrt(3) / 3, PI / 6),
                Arguments.of(Math.sqrt(3), Double.NaN),
                Arguments.of(1, PI / 4)
        );
    }
}
