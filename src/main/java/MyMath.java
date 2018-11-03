public class MyMath {
    public static double sqrt(int number) {
        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        } while ((t - squareRoot) != 0);
        return squareRoot;
    }
    public static double square(int number){
        double square = number * number;
        return square;
    }
    public static double cos(int number){
        double cos = Math.cos(number);
        return cos;
    }
    public static void main(String[] arg) {
        //   Scanner scanner = new Scanner(System.in);
        //    int number = scanner.nextInt();
        System.out.println("Calculate...");
    }
}
