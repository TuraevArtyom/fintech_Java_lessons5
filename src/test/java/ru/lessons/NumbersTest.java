package ru.lessons;

import org.junit.Test;
import ru.lessons.Numbers;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class NumbersTest {

    @Test
    public void sqrtTest(){
        Numbers numbers = new Numbers();
        double actual = numbers.sqrt(64);
        double expected = 8.0;
        assertEquals("Wrong value sqrt!",expected, actual,0.0);
    }

    @Test
    public void squareTest(){
        Numbers numbers = new Numbers();
        double actual = numbers.square(4);
        double expected = 16.0;
        assertEquals("Wrong value square!",expected, actual,0.0);
    }

    @Test
    public void cosTest(){
        Numbers numbers = new Numbers();
        double actual = numbers.cos(0);
        double expected = 1.0;
        assertEquals("Wrong value cos!",expected, actual,0.0);
    }

    @Test
    public void calculateFirstFactorialTest(){
        Numbers numbers = new Numbers();
        BigInteger actual = numbers.calculateFirstFactorial(12);
        BigInteger expected = BigInteger.valueOf(479001600);//преобразовываем,
        // т.к. ждет значение типа int в expected по умолчанию
        assertEquals("Wrong value first factorial!",expected, actual);
    }

    @Test
    public void calculateSecondFactorialTest(){
        Numbers numbers = new Numbers();
        long actual = numbers.calculateSecondFactorial(12);
        long expected = 479001600;
        assertEquals("Wrong value second factorial!",expected, actual);
    }
}