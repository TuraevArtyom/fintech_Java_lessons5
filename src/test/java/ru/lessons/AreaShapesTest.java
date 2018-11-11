package ru.lessons;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
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
        AreaShapes areaShapes = new AreaShapes();
        double actual = areaShapes.areaTriangle(3,4,5);
        double expected = 6.0;
        assertThat(areaShapes, is(notNullValue()));
        assertEquals(expected, actual, "Wrong value sides!");
    }

    @Tag("polygon")
    @ParameterizedTest
    @ValueSource(doubles = { 4, 166 })
    void areaSquareTest(){
        AreaShapes areaShapes = new AreaShapes();
        double actual = areaShapes.areaSquare(4);
        double expected = 16.0;
        assertThat(areaShapes, is(notNullValue()));
        assertEquals(expected, actual, "Wrong value side!");
    }

    @Tag("ellipse")
    @ParameterizedTest
    @CsvSource({ "12,3,4", "12,2,6" })
    void areaCircleTest(){
        AreaShapes areaShapes = new AreaShapes();
        double actual = areaShapes.areaCircle(1);
        double expected = Math.PI;
        assertThat(areaShapes, is(notNullValue()));
        assertEquals(expected, actual, "Wrong value radius!");
    }
}