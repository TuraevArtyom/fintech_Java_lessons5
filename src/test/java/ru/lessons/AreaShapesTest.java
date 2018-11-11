package ru.lessons;
import org.junit.runners.Parameterized;
import org.junit.jupiter.api.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
class AreaShapesTest {

    @Test
    void areaTriangleTest(){
        AreaShapes areaShapes = new AreaShapes();
        double actual = areaShapes.areaTriangle(3,4,5);
        double expected = 6.0;
        assertThat(areaShapes, is(notNullValue()));
        assertEquals(expected, actual, "Wrong value sides!");
    }

    @Test
    void areaSquareTest(){
        AreaShapes areaShapes = new AreaShapes();
        double actual = areaShapes.areaSquare(4);
        double expected = 16.0;
        assertThat(areaShapes, is(notNullValue()));
        assertEquals(expected, actual, "Wrong value side!");
    }

    @Test
    void areaCircleTest(){
        AreaShapes areaShapes = new AreaShapes();
        double actual = areaShapes.areaCircle(1);
        double expected = Math.PI;
        assertThat(areaShapes, is(notNullValue()));
        assertEquals(expected, actual, "Wrong value radius!");
    }
}