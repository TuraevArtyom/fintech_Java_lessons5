package ru.lesson1;

import org.junit.Test;

import java.math.BigInteger;

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

    @Test
    public void factorial() {
        Numbers numbers = new Numbers();
        BigInteger actual = numbers.factorial(12);
        BigInteger expected = BigInteger.valueOf(479001600);//преобразовываем, т.к. ждет значение типа int по умолчанию
        assertEquals(expected, actual);
    }

    @Test
    public void another_factorial() {
        Numbers numbers = new Numbers();
        long actual = numbers.another_factorial(12);
        long expected = 479001600;
        assertEquals(expected, actual);
    }
}