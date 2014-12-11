/**************************************************************************************
compilation:  javac -cp .:stdlib.jar MeanAndSD.java
execution:  java -cp .:stdlib.jar MeanAndSD [N]

Reads an integer N from the command line and N double values from standard input, then prints their mean and standard deviation.

$ java -cp .:stdlib.jar MeanAndSD 8
14.2 2 13.0 4.4 9 20.2 5 11 14.4
The average is 9.85
The standard deviation is 2.2716531784727407

java -cp .:stdlib.jar MeanAndSD 4
5 5 5 5
The average is 5.0
The standard deviation is 0.0
***************************************************************************************/

public class MeanAndSD {
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      double[] data = new double[N];
      double sum = 0.0;
      for (int i = 0; i < N; i++) {
         data[i] = StdIn.readDouble();
         sum += data[i];
      }
      double average = sum / N;
      double squaresum = 0.0;
      for (int i = 0; i < N; i++) {
         squaresum += (data[i] - average) * (data[i] - average);
      }
      double stddev = Math.sqrt(squaresum) / (N - 1);
      StdOut.println("The average is " + average);
      StdOut.println("The standard deviation is " + stddev);
   }
}