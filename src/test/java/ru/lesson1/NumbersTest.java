package ru.lesson1;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumbersTest {

    @Test
    public void sqrt() {
        Numbers numbers = new Numbers();
        double actual = numbers.sqrt(64);
        double expected = 8.0;
        assertEquals(expected, actual,0.0);
    }

    @Test
    public void square() {
        Numbers numbers = new Numbers();
        double actual = numbers.square(4);
        double expected = 16.0;
        assertEquals(expected, actual,0.0);
    }

    @Test
    public void cos() {
        Numbers numbers = new Numbers();
        double actual = numbers.cos(0);
        double expected = 1.0;
        assertEquals(expected, actual,0.0);
    }
}