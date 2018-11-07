package ru.lesson1;

import java.math.BigInteger;

public class Numbers {
    public static double sqrt(double number){
        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        } while ((t - squareRoot) != 0);
        return squareRoot;
    }
    public static double square(double number){
        double square = number * number;
        return square;
    }
    public static double cos(double number){
        double cos = Math.cos(number);
        return cos;
    }
    public static BigInteger factorial(int n ){
        if ( n < 0 ) throw new IllegalArgumentException( "n mustn't be negative.") ;
        BigInteger result = BigInteger.ONE;
        for ( int i = 2 ; i <= n ; i++ ) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result ;
    }
    public static long another_factorial( long n ){
        return (n == 0) ? 1 : n * another_factorial (n - 1);}

    public static void main(String[] arg){
        Numbers numbers = new Numbers();
        double square_result = numbers.square(4);
        double sqrt_result = numbers.sqrt(64);
        double cos_result = numbers.cos(0);
        System.out.println("Calculate..." + square_result + " " + sqrt_result + ' ' + cos_result);
        System.out.println(factorial(13));
        System.out.println(another_factorial(13));
    }
}


