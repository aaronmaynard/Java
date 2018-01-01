public class Main {
    // Main
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    // Factorial
    public static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }

        return n * fact(n-1);
    }
}
