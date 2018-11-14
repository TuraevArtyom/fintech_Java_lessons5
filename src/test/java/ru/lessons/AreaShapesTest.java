package ru.lessons;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;


class AreaShapesTest {

    @Tag("polygon")
    @Test
    void areaTriangleTest(){
        double actual = AreaShapes.areaTriangle(3,4,5);
        double expected = 6.0;
        assertThat(actual, is(notNullValue()));
        assertEquals(expected, actual, "Wrong value sides!");
    }

    @Tag("polygon")
    @ParameterizedTest(name = "Check value")
    @DisplayName("Check area function for square")
    @ValueSource(doubles = { 0, 3.99999, 4.00001 })
    void areaSquareTest(double side){
        double dangerousValue = AreaShapes.areaSquare(side);
        double actual1 = AreaShapes.areaSquare(4);
        double expected = 16.0;
        assertThat(actual1, is(notNullValue()));
        assertNotEquals(expected, dangerousValue, "Right value side!");
        assertEquals(expected, actual1, "Wrong value side!");
    }

    @Tag("ellipse")
    @ParameterizedTest(name = "Check value")
    @DisplayName("Check area function for circle")
    @CsvSource({ "12", "1" })
    void areaCircleTest(double radius){
        double actual = AreaShapes.areaCircle(1);
        double actualForDifferentRadius = AreaShapes.areaCircle(radius);
        double expected = Math.PI;
        assertThat(actual, is(notNullValue()));
        assertTrue(actualForDifferentRadius > 0,"Radius must be more than 0!");
        assertEquals(expected, actual, "Wrong value radius!");
    }

}
