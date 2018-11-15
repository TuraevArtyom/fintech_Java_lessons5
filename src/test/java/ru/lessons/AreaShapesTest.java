package ru.lessons;

import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.provider.Arguments;


class AreaShapesTest {

    public static Stream<Arguments> sidesTriangleAndAreaExpectedValue() {
        return Stream.of(
                Arguments.of(3.0,4.0,5.0,6.0),
                Arguments.of(9.0,40.0,41.0,180.0),
                Arguments.of(1.0,1.0,Math.sqrt(2.0),0.5),
                Arguments.of(Math.sqrt(5),Math.sqrt(5),2.0,2.0),
                Arguments.of(Math.sqrt(5),Math.sqrt(5),4.0,2.0),//а вот тут дельты не хватает, площадь различается слабо
                //но если уменьшить дельту на один порядок, падает и тест с (1,1,sqrt(2),0.5)
                Arguments.of(5.0,12.0,13.0,30.0));
    }
    @Tag("polygon")
    @ParameterizedTest(name = "Check value")
    @DisplayName("Check area function for triangle")
    @MethodSource("sidesTriangleAndAreaExpectedValue")
    void areaTriangleTest(double sideAB, double sideBC, double sideCA,double expected){
        double actual = AreaShapes.areaTriangle(sideAB,sideBC,sideCA);
        assertThat(actual, is(notNullValue()));
        assertEquals(expected, actual,0.000000000000001, "Wrong value sides!");
    }

    @Tag("polygon")
    @Test
    @DisplayName("Check area function for square")
    void areaSquareTest(){
        double actual1 = AreaShapes.areaSquare(4);
        double expected = 16.0;
        assertThat(actual1, is(notNullValue()));
        assertEquals(expected, actual1, "Wrong value side!");
    }

    @Tag("ellipse")
    @ParameterizedTest(name = "Check value")
    @DisplayName("Check area function for circle")
    @CsvSource({ "1, 3.141592653589793", "3,28.274333882308138","0.5,0.7853981633974483"})
    void areaCircleTest(double radius, double expected){
        double actual = AreaShapes.areaCircle(radius);
        double actualForDifferentRadius = AreaShapes.areaCircle(radius);
        assertThat(actual, is(notNullValue()));
        assertTrue(actualForDifferentRadius > 0,"Radius must be more than 0!");
        assertEquals(expected, actual, "Wrong value radius!");
    }

}
