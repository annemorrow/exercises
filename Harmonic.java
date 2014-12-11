/**************************************************************************************
compilation:  javac -cp .:stdlib.jar Harmonic.java
execution:  java -cp .:stdlib.jar Harmonic

Reads in N positive real numbers from standard input and prints out their geometric and 
harmonic means.

Double check both definitions before committing.
***************************************************************************************/

public class Harmonic {
   public static void main(String[] args) {
      int N = StdIn.readInt();
      double[] data = new double[N];
      for (int i = 0; i < N; i++) {
         data[i] = StdIn.readDouble();
      }
      double harmonic = 0.0;
      for (int i = 0; i < N; i++) {
         harmonic += 1 / data[i];
      }
      harmonic *= N;
      // using logs to find the geometric mean to prevent overflow
      double geometric = 0.0;
      for (int i = 0; i < N; i++) {
         geometric += Math.log10(data[i]);
      }
      geometric = Math.pow(10.0, geometric/N);
      StdOut.printf("The geometric mean is %14.4f \n", geometric);
      StdOut.printf("The harmonic mean is %14.4f \n", harmonic);
   }
}