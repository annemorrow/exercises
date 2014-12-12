/****************************************************************************************
compilation:  javac -cp .:stdlib.jar NumberTheory.java
execution:  java -cp .:stdlib.jar NumberTheory

A library for common number theory functions.

void        factors(int n)                   prints a list of factors of n
void        factors(long n)
int         GCD(int x, int y)                returns the greatest common factor of x and y
long        GCD(long x, long y)   
boolean     isPrime(int n)                   returns true if n is prime
boolean     isPrime(long n)                  
int         LCM(int x, int y)                returns the least common multiple of x and y
long        LCM(long x, long y)
boolean     relativelyPrime(int x, int y)    returns true if x and y are relatively prime
boolean     relativelyPrime(long x, long y)
int         totient(int x)                   returns phi(x) where phi is Euler's totient function
long        totient(long x)             
****************************************************************************************/

public class NumberTheory {
   
   public static boolean isPrime(int n) {
      for (int i = 2; i <= n / i; i++) {
         if (n % i == 0) return false;
      }
      return true;
   }
   
   public static boolean isPrime(long n) {
      for (long i = 2; i <= n / i; i++) {
         if (n % i == 0) return false;
      }
      return true;
   }
   
   public static boolean relativelyPrime(int x, int y) {
      if (GCD(x, y) == 1) return true;
      else return false;
   }
   
   public static boolean relativelyPrime(long x, long y) {
      if (GCD(x, y) == 1) return true;
      else return false;
   }
   
   public static int GCD (int x, int y) {
      if (x == 0) return y;
      if (y == 0) return x;
      int big = Math.max(x, y);
      int small = Math.min(x, y);
      int r = big % small;       
      while(r > 0) {
         big = small;
         small = r;
         r = big % small;
      }
      return small;
   }
   
   public static long GCD (long x, long y) {
      if (x == 0) return y;
      if (y == 0) return x;
      long big = Math.max(x, y);
      long small = Math.min(x, y);
      long r = big % small;
      while (r > 0) {
         big = small;
         small = r;
         r = big % small;
      }
      return small;
   }
   
   public static void factors (int n) {
      for (int i = 1; i <= n; i++) {
         if (n % i == 0) StdOut.print(i + "\t");
      }
      StdOut.println();
   }
   
   public static void factors (long n) {
      for (long i = 1; i <= n; i++) {
         if (n % i == 0) StdOut.print(i + "\t");
      }
      StdOut.println();
   }
   
   public static int LCM (int x, int y) {
      return (x / GCD(x, y) * y);
   }
   
   public static long LCM (long x, long y) {
      return (x / GCD(x, y) * y);
   }
   
   public static int totient (int x) {
      int count = 0;
      for (int i = 1; i <= x; i++) {
         if (relativelyPrime(x, i)) count++;
      }
      return count;
   }
   
   public static long totient (long x) {
      long count = 0;
      for (long i = 1; i <= x; i++) {
         if (relativelyPrime(x, i)) count++;
      }
      return count;
   }
   
   public static void main(String[] args) {
      int x = Integer.parseInt(args[0]);
      int y = Integer.parseInt(args[1]);
      long a = Long.parseLong(args[2]);
      long b = Long.parseLong(args[3]);
      StdOut.print("The factors of " + x + " are ");
      factors(x);
      StdOut.println("The GCD of " + x + " and " + y + " is " + GCD(x, y));
      StdOut.println(x + " is prime: " + isPrime(x));
      StdOut.println("The LCM of " + x + " and " + y + " is " + LCM(x, y));
      StdOut.println(x + " and " + y + " are relatively prime: " + relativelyPrime(x, y));
      StdOut.println("phi(" + x + ") = " + totient(x));
      StdOut.print("The factors of " + a + " are ");
      factors(a);
      StdOut.println("The GCD of " + a + " and " + b + " is " + GCD(a, b));
      StdOut.println(a + " is prime: " + isPrime(a));
      StdOut.println("The LCM of " + a + " and " + b + " is " + LCM(a, b));
      StdOut.println(a + " and " + b + " are relatively prime: " + relativelyPrime(a, b));
      StdOut.println("phi(" + a + ") = " + totient(a));
   }
   
}