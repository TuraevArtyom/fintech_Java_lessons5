package ru.lesson1;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class NumbersTest {

    @Test
    public void sqrt(){
        Numbers numbers = new Numbers();
        double actual = numbers.sqrt(64);
        double expected = 8.0;
        assertEquals("Wrong value sqrt!",expected, actual,0.0);
    }

    @Test
    public void square(){
        Numbers numbers = new Numbers();
        double actual = numbers.square(4);
        double expected = 16.0;
        assertEquals("Wrong value square!",expected, actual,0.0);
    }

    @Test
    public void cos(){
        Numbers numbers = new Numbers();
        double actual = numbers.cos(0);
        double expected = 1.0;
        assertEquals("Wrong value cos!",expected, actual,0.0);
    }

    @Test
    public void calculateFirstFactorial(){
        Numbers numbers = new Numbers();
        BigInteger actual = numbers.factorial(12);
        BigInteger expected = BigInteger.valueOf(479001600);//преобразовываем,
        // т.к. ждет значение типа int в expected по умолчанию
        assertEquals("Wrong value first factorial!",expected, actual);
    }

    @Test
    public void calculateSecondFactorial(){
        Numbers numbers = new Numbers();
        long actual = numbers.another_factorial(12);
        long expected = 479001600;
        assertEquals("Wrong value second factorial!",expected, actual);
    }
}