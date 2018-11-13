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
    @ValueSource(doubles = { 0, 3.99999, 4.00001 })
    void areaSquareTest(double side){
        AreaShapes areaShapes = new AreaShapes();
        double dangerousValue = areaShapes.areaSquare(side);
        double actual1 = areaShapes.areaSquare(4);
        double expected = 16.0;
        assertThat(areaShapes, is(notNullValue()));
        assertNotEquals(expected, dangerousValue, "Right value side!");
        assertEquals(expected, actual1, "Wrong value side!");
    }

    @Tag("ellipse")
    @ParameterizedTest
    @CsvSource({ "12", "1" })
    void areaCircleTest(){
        AreaShapes areaShapes = new AreaShapes();
        double actual = areaShapes.areaCircle(1);
        double expected = Math.PI;
        assertThat(areaShapes, is(notNullValue()));
        assertTrue(actual > 0,"Radius must be more than 0!");
        assertEquals(expected, actual, "Wrong value radius!");
    }
}